<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin|cou_type</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<base>
<%@ include file="/include/common-css.jsp"%>
</head>

<body>
	<%@ include file="/include/page-header.jsp"%>
	<div class="main">
		<%@ include file="/include/page-nav.jsp"%>
		<div class="table-main">
			<ul class="uk-breadcrumb">
				<li><a href="#">首页 </a></li>
				<li><a href="#">课程管理</a></li>
				<li><a href="#">开班</a></li>
			</ul>
			<div class="uk-overflow-auto" style="margin-top: 30px">
				<table id="dataTable" class="" data-toggle="table"
					data-pagination="true" data-url="/course/couTypeList"
					data-content-type="application/x-www-form-urlencoded"
					data-method="get" data-show-columns="true" data-show-refresh="true"
					data-page-number="1" data-page-size="10"
					data-page-list="[10, 20, 50]" data-striped="true"
					data-search="true" data-toolbar="#toolbar">
					<thead>
						<tr>
							<th data-width="60px" data-formatter="serialNumGen"
								data-align="center">#</th>
							<th data-field="course_code" data-sortable="true">课程代码</th>
							<th data-field="course_name" data-sortable="true">课程名</th>
							<th data-field="classNum" data-sortable="true" data-align="center">开班数</th>
							<th data-width="200px" data-align="center"
								data-formatter="actionFormatter">操作</th>
						</tr>
					</thead>
				</table>
			</div>

		</div>
		<a class="side-icon " uk-tooltip="添加课程 " href="#modal-overflow"
			uk-toggle> <span uk-icon="icon:plus;ratio: 1.5"></span></a>


		<div id="modal-overflow" uk-modal>
			<div class="uk-modal-dialog">

				<button class="uk-modal-close-default" type="button" uk-close></button>

				<div class="uk-modal-header">
					<h2 class="uk-modal-title">添加课程</h2>
				</div>

				<div class="uk-modal-body" uk-overflow-auto>
					<form action="">
						<div class="form-group row">
							<label class="col-md-3 form-control-label" for="name">课程代码：
								<span class="required" style="color: red;">*</span>
							</label>
							<div class="col-md-9">
								<input type="text" value="" class="form-control"
									name="courseCode" placeholder="请输入课程代码" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-md-3 form-control-label" for="name">课程名：
								<span class="required" style="color: red;">*</span>
							</label>
							<div class="col-md-9">
								<input type="text" value="" class="form-control"
									name="courseName" placeholder="请输入课程名称" />
							</div>
						</div>
						<div class="uk-text-right">
							<div class="form-group">
								<button class="uk-button uk-button-default uk-modal-close"
									type="reset">取消</button>

								<button class="uk-button uk-button-primary" type="button"
									name="submit" id="submitBtn">保存</button>

							</div>
						</div>
					</form>
				</div>


			</div>
		</div>
	</div>
</body>
<%@ include file="/include/common-js.jsp"%>
<script>
	//设置导航栏高度
	function setNavHeight() {
		var headerHeight = $("header").height();
		var navHeight = $(document.body).height() - headerHeight + 'px';
		$(".nav-main").css({
			"height" : navHeight,
			"margin-top" : headerHeight
		})
	}
	//设置表格位置
	function setTablePosition() {
		var headerHeight = $("header").height();
		var navWidth = $(".nav-main").width();
		var top = headerHeight + 60 + 'px';
		var left = navWidth + 150 + 'px';
		$(".table-main").css({
			"padding-top" : top,
			"padding-left" : left
		})
	}
	//监听页面加载事件
	$(document).ready(function() {
		setNavHeight();
		setTablePosition();
		$(document.body).css("opacity", 1);
		//监听窗口变化事件
		$(window).resize(function() {
			setNavHeight();
			setTablePosition();
		});
	})
</script>
<script>
	$(function() {
		var form = $("form");
		function formValidator(){
			//初始化input状态样式图标
			var icon = {};
			//初始化验证规则
			form.bootstrapValidator({
				feedbackIcons : icon, //加载图标
				/* 生效规则
				 * enabled:字段值发生变化就触发验证
				 * disabled/submitted:点击提交时触发验证
				 */
				live: 'disabled',
				//表单域配置
				fields : {
					courseCode : {//username为input标签name值
						validators : {
							notEmpty : {
								message : '请输入课程代码'
							}
						}
					},
					courseName : {
						validators : {
							notEmpty : {
								message : '请输入课程名'
							}
						}
					}
				//最后一个没有逗号
				}
			});
		}
		formValidator();
		
		$("#submitBtn").click(function () {
			var formName = 'form'
	        //进行表单验证
	        var bv = form.data('bootstrapValidator');
	        bv.validate();
	        if (bv.isValid()) {
	            console.log(form2Json(formName));
	            //发送ajax请求
	            axios.post('/course/couTypeAdd',JSON.stringify(form2Json(formName)))
	              .then(function (response) {
	            	  if(response.data.state == 'ok'){
		            	  $('#dataTable').bootstrapTable('refresh');
		            	  UIkit.notification({
	            			    message: '添加成功！',
	            			    pos: 'bottom-center',
	            			    timeout: 3000
	            			});
	            	  }else{
	            		  
	            		  var message = response.data.message
	            		  UIkit.notification({
	            			    message: '添加失败!&nbsp;&nbsp;&nbsp;原因：' + message,
	            			    pos: 'bottom-center',
	            			    timeout: 3000
	            			});
	            		
	            		  
	            	  }
	            	  UIkit.modal($("#modal-overflow")).hide();
	            	//清除隐藏元素表达内容的关键
	            	  formReset(formName);
            		  form.data('bootstrapValidator').resetForm();
	            	  
	              })
	              .catch(function (error) {
	                console.log(error);
	              });
	        }
	    });
	});
</script>
<script>
	//操作
	function actionFormatter(value, row, index) {
		var _open = "";
		var _delete = "";
		var _show = "";
		_show ='<a class="btn btn-link btn-xs text-danger" href="/admin/course/base?couCode='+ row.course_code +'" >查看所有班级 </a>';
		_open ='<a class="btn btn-link btn-xs text-primary" href="/admin/course/open?couCode='+ row.course_code + '">开班</a>';
		_delete ='<a class="btn btn-link btn-xs text-danger" href="javascript:void(0);" onclick="couTypeDelete('+ row.id +')">删除 </a>';
		
		return _show+ _open+ _delete;
	}
	function couTypeDelete(id){
		UIkit.modal.confirm('确定删除吗？',{
			labels:{
				ok:'确定',
				cancel:'取消'
			}
		}).then(function() {
			axios.post('/course/couTypeDelete',id)
            .then(function (response) {
          	  if(response.data.state == 'ok'){
	            	  $('#dataTable').bootstrapTable('refresh');
	            	  UIkit.notification({
          			    message: '删除成功！',
          			    pos: 'bottom-center',
          			    timeout: 3000
          			});
          	  }else{
          		UIkit.notification({
      			    message: '删除失败！',
      			    pos: 'bottom-center',
      			    timeout: 3000
      			});
          	  }
          	  UIkit.modal($("#modal-overflow")).hide();
          	//清除隐藏元素表达内容的关键
          	  formReset(formName);
      		  form.data('bootstrapValidator').resetForm();
          	  
            })
            .catch(function (error) {
              console.log(error);
            });
		}, function () {
		    console.log('取消')
		});
		
	}
</script>
</html>