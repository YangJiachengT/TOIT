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
						data-pagination="true"
						data-url="/course/couBaseList?couCode=${course_code}"
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
								<th data-field="class_name" data-sortable="true">课程名</th>
								<th data-field="user_real_name" data-sortable="true"
									data-align="center">讲师</th>
								<th data-field="start_time" data-sortable="true"
									data-align="center">课程开始时间</th>
								<th data-field="end_time" data-sortable="true"
									data-align="center">课程结束时间</th>
								<th data-field="least_number" data-sortable="true"
									data-align="center">最少开班人数</th>
								<th data-field="most_number" data-sortable="true"
									data-align="center">最大开班人数</th>
								<th data-field="course_deadline" data-sortable="true"
									data-align="center">报名截止时间</th>
								<th data-field="course_place" data-sortable="true"
									data-align="center">上课地点</th>
								<th data-field="course_describe" data-sortable="true"
									data-align="center">备注</th>
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