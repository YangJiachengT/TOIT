<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="container-fluid">
	<div class="row">
		<div class="head">
			<span>后台</span> <span class="admin uk-button uk-button-default">管理员</span>
			<div uk-dropdown="mode: click">
				<ul class="uk-nav uk-dropdown-nav">
					<li><a href="#">消息</a></li>
					<li><a href="#">Item</a></li>
					<li class="uk-nav-divider"></li>
					<li><span uk-icon="icon: sign-out"></span><span><a
							href="#">退出</a></span></li>
				</ul>
			</div>
		</div>
	</div>
</header>