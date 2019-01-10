<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin | cou_type</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<base>
<%@ include file="/include/common-css.jsp"%>
</head>

<body class="animsition dashboard">
	<%@ include file="/include/page-nav.jsp"%>
	<!-- Page -->
	<div class="page">
		<div class="page-header">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="javascript:void(0)">一级</a></li>
				<li class="breadcrumb-item active">二级</li>
			</ol>
		</div>

		<div class="page-content">
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title"></h3>
				</div>
				<div class="panel-body">
					<table id="dataTable" class="" data-toggle="table"
						data-pagination="true" data-url="/course/couTypeList"
						data-content-type="application/x-www-form-urlencoded"
						data-method="get" data-show-columns="true"
						data-show-refresh="true" data-page-number="1" data-page-size="10"
						data-page-list="[10, 20, 50]" data-striped="true"
						data-search="true" data-toolbar="#toolbar">
						<thead>
							<tr>
								<th data-width="60px" data-formatter="serialNumGen"
									data-align="center">#</th>
								<th data-field="course_code" data-sortable="true">课程代码</th>
								<th data-field="course_name" data-sortable="true">课程名</th>
								<th data-field="classNum" data-sortable="true"
									data-align="center">开班数</th>
								<th data-width="200px" data-align="center"
									data-formatter="actionFormatter">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>

	</div>
	<!-- End Page -->

	<!-- site-action -->
	<div class="site-action">
		<a href="javascript:void(0)" data-toggle="modal"
			data-target="#myModal">
			<button type="button"
				class="site-action-toggle btn-raised btn btn-success btn-floating">
				<i class="front-icon wb-plus animation-scale-up" aria-hidden="true"></i>
			</button>
		</a>
	</div>

	<!-- Modal -->
	<div class="bootbox modal fade" id="myModal" tabindex="-1"
		role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="bootbox-close-button close"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title">添加课程</h4>
				</div>
				<div class="modal-body">
					<div class="bootbox-body">
						<form class="form-horizontal">
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
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button data-bb-handler="success" type="button"
						data-dismiss="modal" aria-hidden="true" class="btn btn-default">取消</button>
					<button data-bb-handler="success" type="button"
						class="btn btn-success" id="submitBtn">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer class="site-footer">
	<div class="site-footer-legal">
		© 2019 <a href="#">学生素质测评系统TOIT</a>
	</div>
	<div class="site-footer-right">
		Crafted with by <a href="#">Liu</a>
	</div>
	</footer>
</body>
<%@ include file="/include/common-js.jsp"%>
<script>
$(document).ready(function() {
	//弹框初始化
	alertify.delay(1000);
});
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
		            	  alertify.success("添加成功");
	            	  }else{
	            		  var message = response.data.message;
	            		  var str = "添加失败 " + message;
	            		  alertify.error(str);
	            	  }
	            	  $('#myModal').modal('hide');
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
	
	$('#myModal').on('hide.bs.modal', function (e) {
		var formName = 'form';
		var form = $("form");
		//清除隐藏元素表达内容的关键
		formReset(formName);
		form.data('bootstrapValidator').resetForm();
	})
</script>
<script>
	//操作
	function actionFormatter(value, row, index) {
		var _open = "";
		var _delete = "";
		var _show = "";
		_show = '<a class="btn btn-xs text-primary" href="/admin/course/base?couCode='
				+ row.course_code + '" >查看所有班级 </a>';
		_open = '<a class="btn btn-xs text-primary" href="/admin/course/open?couCode='
				+ row.course_code + '">开班</a>';
		_delete = '<a class="btn btn-xs text-danger" href="javascript:void(0);" onclick="couTypeDelete('
				+ row.id + ')">删除 </a>';

		return _show + _open + _delete;
	}
	function couTypeDelete(id) {
		alertify.confirm("确定要删除该条记录吗？", function() {
			axios.post('/course/couTypeDelete',id)
            .then(function (response) {
          	  if(response.data.state == 'ok'){
	            $('#dataTable').bootstrapTable('refresh');
	            alertify.success("删除成功");
          	  }else{
          		alertify.error("删除失败");
          	  }
          	$('#myModal').modal('hide');
          	//清除隐藏元素表达内容的关键
          	  formReset(formName);
      		  form.data('bootstrapValidator').resetForm();
          	  
            })
            .catch(function (error) {
              console.log(error);
            });
		}, function() {
			//alertify.error("取消");
		});
	}
</script>
</html>