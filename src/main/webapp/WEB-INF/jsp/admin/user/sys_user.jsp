<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin|home</title>
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
				<li class="breadcrumb-item"><a href="javascript:void(0)">首页</a></li>
				<li class="breadcrumb-item active">1</li>
			</ol>
		</div>

		<div class="page-content">
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title"></h3>
				</div>
				<div class="panel-body">
					<table id="dataTable" class="" data-toggle="table"
						data-pagination="true" data-url="/user/userList"
						data-content-type="application/x-www-form-urlencoded"
						data-method="get" data-page-number="1" data-page-size="10"
						data-page-list="[2, 4, 50]" data-striped="true" data-search="true">
						<thead>
							<tr>
								<th data-width="60px" data-formatter="serialNumGen"
									data-align="center">#</th>
								<th data-field="user_name" data-sortable="true"
									data-align="center">学号/工号</th>
								<th data-field="user_real_name" data-sortable="true"
									data-align="center">姓名</th>
								<th data-field="user_type" data-sortable="true"
									data-align="center">角色</th>
								<th data-field="create_date" data-sortable="true">创建时间</th>
								<th data-field="lastest_login_ip" data-sortable="true">最近登录IP</th>
								<th data-field="lastest_login_time" data-sortable="true">最近登录时间</th>
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
					<h4 class="modal-title">添加用户</h4>
				</div>
				<div class="modal-body">
					<div class="bootbox-body">
						<form class="form-horizontal">
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">学号/工号：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<input type="text" value="" class="form-control"
										name="userName" placeholder="请输入用户学号/工号" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 form-control-label" for="name">用户类型：
									<span class="required" style="color: red;">*</span>
								</label>
								<div class="col-md-9">
									<select class="form-control" name="userType">
										<option value="">请选择</option>
										<option value="1">学生</option>
										<option value="2">教师</option>
									</select>
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
					userName : {//username为input标签name值
						validators : {
							notEmpty : {
								message : '请输入学号/工号'
							}
						}
					},
					userType : {
						validators : {
							notEmpty : {
								message : '请选择用户类型'
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
	            axios.post('/user/userAdd',JSON.stringify(form2Json(formName)))
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
	var _delete = "";
	var _restPwd = "";
	_restPwd = '<a class="btn btn-xs text-primary" href="javascript:void(0);" onclick="restPwd(\''+row.id+'\')">重置密码 </a>';
	_delete = '<a class="btn btn-xs text-danger" href="javascript:void(0);" onclick="Delete(\''+row.id+'\')">删除 </a>';

	return _restPwd + _delete;
}
function Delete(id) {
	alertify.confirm("确定要删除该用户吗？", function() {
		axios.post('/user/userDelete',id)
        .then(function (response) {
      	  if(response.data.state == 'ok'){
            $('#dataTable').bootstrapTable('refresh');
            alertify.success("删除成功");
      	  }else{
      		alertify.error("删除失败");
      	  }
      	  
        })
        .catch(function (error) {
          console.log(error);
        });
	}, function() {
		//alertify.error("取消");
	});
}
function restPwd(id){
	axios.post('/user/userResetPwd',id)
    .then(function (response) {
  	  if(response.data.state == 'ok'){
        alertify.success("重置成功");
  	  }else{
  		alertify.error("重置失败");
  	  }
  	  
    })
    .catch(function (error) {
      console.log(error);
    });
}
</script>
</html>