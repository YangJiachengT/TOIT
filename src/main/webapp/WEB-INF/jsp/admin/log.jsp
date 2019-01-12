<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>标题</title>
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
				<li class="breadcrumb-item active">日志</li>
			</ol>
		</div>

		<div class="page-content">
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title"></h3>
				</div>
				<div class="panel-body">
					<table id="dataTable" class="" data-toggle="table"
						data-pagination="true" data-url="/log"
						data-content-type="application/x-www-form-urlencoded"
						data-method="get" data-show-columns="true"
						data-show-refresh="true" data-page-number="1" data-page-size="10"
						data-page-list="[10, 20, 50]" data-striped="true"
						data-search="true" data-toolbar="#toolbar">
						<thead>
							<tr>
								<th data-width="60px" data-formatter="serialNumGen"
									data-align="center">#</th>
								<th data-field="method" data-sortable="true">方法</th>
								<th data-field="operation_describe" data-sortable="true">操作</th>
								<th data-field="return_value" data-sortable="true"
									data-align="center">状态</th>
								<th data-field="run_time" data-sortable="true"
									data-align="center">运行时间</th>
								<th data-field="user_real_name" data-sortable="true"
									data-align="center">操作人</th>
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