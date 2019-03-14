<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="no-js css-menubar" lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description" content="bootstrap admin template">
<meta name="author" content="">
<title>Login | 登录</title>
<link rel="apple-touch-icon" href="/assets/images/apple-touch-icon.png">
<!-- Stylesheets -->
<link rel="stylesheet" href="/assets/css/page/bootstrap.min.css">
<link rel="stylesheet" href="/assets/css/page/bootstrap-extend.min.css">
<link rel="stylesheet" href="/assets/css/site.css">
<!-- Plugins -->
<link rel="stylesheet" href="/assets/vendor/animsition/animsition.css">
<link rel="stylesheet"
	href="/assets/vendor/formvalidation/formValidation.min.css">
<!-- Fonts -->
<!-- 	<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,300italic'> -->
<link rel="stylesheet" href="/assets/fonts/web-icons/web-icons.min.css">
<link rel="stylesheet"
	href="/assets/fonts/brand-icons/brand-icons.min.css" />
<link rel="stylesheet" href="/assets/css/page/login.css">
<!-- Scripts -->
<script src="/assets/vendor/breakpoints/breakpoints.js?v=1.0.5"></script>
<script>
	Breakpoints();
</script>
<style>
body {
	background: transparent;
}

.social-wechat {
	color: #fff;
	background-color: #06a75a !important;
}

.social-wechat:hover, .social-wechat:focus {
	color: #fff;
	background-color: #08c36a !important;
}

.page-login-v2:before {
	background: url(/assets/images/login-bg.jpeg);
	background-position: center;
	background-size: cover;
}

.page-dark.layout-full::before {
	z-index: 0;
}
.btn-icon{
	display:inline;
}
</style>
</head>
<body class="animsition page-login-v2 layout-full page-dark">
	<!-- Page -->
	<div class="page" data-animsition-in="fade-in"
		data-animsition-out="fade-out">
		<div class="page-content">
			<div class="page-brand-info">
				<div class="brand">
					<h2 class="brand-text font-size-40"></h2>
				</div>
				<p class="font-size-20"></p>
			</div>

			<div
				class="page-login-main animation-slide-right animation-duration-1">
				<div class="brand hidden-md-up">
					<img class="brand-img"
						src="../../assets/images/logo-colored@2x.png" alt="...">
					<h3 class="brand-text font-size-40">Remark</h3>
				</div>
				<h3 class="font-size-24">登录</h3>
				<p></p>

				<form><!--  method="post" action="/login" -->
					<div class="alert alert-danger display-hide" id="alert"
						style="display: none;">
						<button aria-label="Close" data-dismiss="alert" class="close"
							type="button">
							<span aria-hidden="true">×</span>
						</button>
						<span id="alertMessage"></span>
					</div>
					<div class="form-group">
						<label class="sr-only" for="inputUsername">账号</label> <input
							type="text" class="form-control" id="username" name="username"
							placeholder="用户名">
					</div>
					<div class="form-group">
						<label class="sr-only" for="inputPassword">密码</label> <input
							type="password" class="form-control" id="password"
							name="password" placeholder="密码">
					</div>
					<!-- <div class="form-group clearfix">
						<div
							class="checkbox-custom checkbox-inline checkbox-primary float-left">
							<input type="checkbox" id="rememberMe" name="rememberMe">
							<label for="rememberMe">记住我</label>
						</div>
						<a class="float-right" href="forgot-password.html">忘记密码?</a>
					</div> -->
					<span class="btn btn-primary btn-block" onclick="login()">登录</span>
					<span class="btn btn-primary btn-block" onclick="loginAsDev()">开发者模式</span>
				</form>

				<!-- <p>
					没有账号? <a href="register-v2.html">注册</a>
				</p> -->

				<footer class="page-copyright">
					<p>学生素质测评系统</p>
					<p>© 2019. All RIGHT RESERVED.</p>
					<div class="social">
						<a class="btn btn-icon btn-round social-google-plus mx-5"
							href="javascript:void(0)"> <i class="icon bd-weibo"
							aria-hidden="true"></i>
						</a> <a class="btn btn-icon btn-round social-tumblr mx-5"
							href="javascript:void(0)"> <i class="icon bd-github"
							aria-hidden="true"></i>
						</a> <a class="btn btn-icon btn-round social-wechat mx-5"
							href="javascript:void(0)"> <i class="icon bd-webchat"
							aria-hidden="true"></i>
						</a> <a class="btn btn-icon btn-round social-github mx-5"
							href="javascript:void(0)"> <i class="icon bd-zhihu"
							aria-hidden="true"></i>
						</a>
					</div>
				</footer>
			</div>

		</div>
	</div>
	<!-- End Page -->
</body>
<!-- Core-->
<script
	src="/assets/vendor/babel-external-helpers/babel-external-helpers.js"></script>
<script src="/assets/vendor/jquery/jquery.min.js?v=3.3.1"></script>
<script type="text/javascript" src="/assets/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/assets/js/login.js?v=1.0.0"></script>
<script src="/assets/vendor/popper-js/umd/popper.min.js"></script>
<script src="/assets/vendor/bootstrap/bootstrap.js"></script>
<script src="/assets/vendor/animsition/animsition.js"></script>

<!-- Plugins -->
<script src="/assets/vendor/jquery-placeholder/jquery.placeholder.js"></script>
<script src="/assets/vendor/formvalidation/formValidation.min.js"></script>
<script src="/assets/vendor/formvalidation/framework/bootstrap4.min.js"></script>
<script src="/assets/vendor/toastr/toastr.js"></script>

<!-- Scripts -->
<script src="/assets/js/Component.js"></script>
<script src="/assets/js/Plugin.js"></script>
<script src="/assets/js/Base.js"></script>
<script src="/assets/js/Config.js"></script>
<script src="/assets/js/Section/Menubar.js"></script>
<script src="/assets/js/Section/Sidebar.js?v=4.0.1"></script>
<script src="/js/axios/axios.js"></script>

<!-- Config -->
<script src="/assets/js/config/tour.js"></script>
<script>
	Config.set('assets', '/assets');
</script>

<!-- Page -->
<script src="/assets/js/Site.js"></script>
<script>
	(function(document, window, $) {
		'use strict';

		var Site = window.Site;
		$(document).ready(function() {
			Site.run();
		});
	})(document, window, jQuery);
</script>
<script>
	$(document).ready(function() {
	});
	function login(){
		var username = $("#username").val();
		var password = $("#password").val();
		axios.get("/login?username="+username+"&password="+password)
		.then(function (response) {
			if(response.data.state == 'ok'){
				window.location.href = '/admin/home';
			}else{
				$("#alert").css("display", "block");
				$("#alertMessage").html(response.data.message)
			}
		})
	}
	function loginAsDev() {
		$("#username").val("0001");
		$("#password").val("123456");
		login();
	}
</script>
</html>
