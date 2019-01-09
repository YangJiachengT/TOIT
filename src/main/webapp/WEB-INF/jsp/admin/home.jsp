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
	
</script>
</html>