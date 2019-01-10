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
<link rel="stylesheet" href="/assets/vendor/dropify/dropify.css" />
</head>

<body class="animsition dashboard">
	<%@ include file="/include/page-nav.jsp"%>
	<!-- Page -->
	<div class="page">
		<div class="page-header">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="javascript:void(0)">首页</a></li>
				<li class="breadcrumb-item active">题库批量导入</li>
			</ol>
		</div>

		<div class="page-content">
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title"></h3>
				</div>
				<div class="panel-body">
					<div role="alert"
						class="alert alert-warning alert-icon alert-dismissible">
						<button aria-label="Close" data-dismiss="alert" class="close"
							type="button">
							<span aria-hidden="true">×</span>
						</button>
						<i class="icon wb-bell" aria-hidden="true"></i>
						<h4>注意！</h4>
						<p>
							1.请使用模板文件填充数据</br> 2.目前仅支持xls及xlsx格式的文件</br>
						</p>
					</div>
					<div class="nav-tabs-horizontal" data-plugin="tabs">
						<ul class="nav nav-tabs nav-tabs-line" role="tablist">
							<li class="nav-item" role="presentation"><a
								class="nav-link active" data-toggle="tab"
								href="#exampleTabsLineOne" aria-controls="exampleTabsLineOne"
								role="tab" aria-selected="true">选择题批量导入</a></li>
							<li class="nav-item" role="presentation"><a class="nav-link"
								data-toggle="tab" href="#exampleTabsLineTwo"
								aria-controls="exampleTabsLineTwo" role="tab"
								aria-selected="false">判断题批量导入</a></li>
						</ul>

						<div class="tab-content pt-20">
							<div class="tab-pane active" id="exampleTabsLineOne"
								role="tabpanel">
								<label>选择题导入</label> <a
									class="btn btn-link float-right text-primary"
									href="/exam/couMultiQuestion/export" target="_self">点击下载导入模板文件</a>
								<form action="/exam/couMultiQuestion/import" method="post"
									enctype="multipart/form-data">
									<input type="file" name="file" id="multiQuestion"
										data-plugin="dropify" data-default-file="">
									<button type="submit" class="btn btn-success my-10 w-200"
										data-toggle="button">
										<i class="icon wb-upload text" aria-hidden="true"></i> <span
											class="text">上传</span>
									</button>
								</form>
							</div>
							<div class="tab-pane" id="exampleTabsLineTwo" role="tabpanel">
								<label>判断题导入</label> <a
									class="btn btn-link float-right text-primary"
									href="/exam/couJudgeQuestion/export" target="_self">点击下载导入模板文件</a>
								<form action="/exam/couJudgeQuestion/import" method="post"
									enctype="multipart/form-data">
									<input type="file" id="judgeQuestion" data-plugin="dropify"
										data-default-file="">
									<button type="submit" class="btn btn-success my-10 w-200"
										data-toggle="button">
										<i class="icon wb-upload text" aria-hidden="true"></i> <span
											class="text">上传</span>
									</button>
								</form>
							</div>
						</div>
					</div>
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
<script type="text/javascript" src="/assets/vendor/dropify/dropify.js"></script>
<script>
	$('#multiQuestion,#judgeQuestion').dropify({
		messages : {
			'default' : '点击或拖拽文件到这里',
			'replace' : '点击或拖拽文件到这里来替换文件',
			'remove' : '移除文件',
			'error' : '对不起，你上传的文件太大了'
		}
	})
</script>
</html>