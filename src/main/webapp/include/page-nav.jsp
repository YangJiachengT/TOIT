<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav
	class="site-navbar navbar navbar-default navbar-fixed-top navbar-mega"
	role="navigation">

	<div class="navbar-header">
		<button type="button"
			class="navbar-toggler hamburger hamburger-close navbar-toggler-left hided"
			data-toggle="menubar">
			<span class="sr-only">Toggle navigation</span> <span
				class="hamburger-bar"></span>
		</button>
		<button type="button" class="navbar-toggler collapsed"
			data-target="#site-navbar-collapse" data-toggle="collapse">
			<i class="icon wb-more-horizontal" aria-hidden="true"></i>
		</button>
		<div class="navbar-brand navbar-brand-center site-gridmenu-toggle"
			data-toggle="gridmenu">
			<span class="navbar-brand-text hidden-xs-down"> 素质测评系统后台</span>
		</div>
	</div>

	<div class="navbar-container container-fluid">
		<!-- Navbar Collapse -->
		<div class="collapse navbar-collapse navbar-collapse-toolbar"
			id="site-navbar-collapse">
			<!-- Navbar Toolbar Right -->
			<ul class="nav navbar-toolbar navbar-right navbar-toolbar-right">
				<li class="nav-item dropdown"><a class="nav-link navbar-avatar"
					data-toggle="dropdown" href="#" aria-expanded="false"
					data-animation="scale-up" role="button"> <span
						class="avatar avatar-online"> <img src="/img/head.jpg"
							alt="...">
					</span>
				</a>
					<div class="dropdown-menu" role="menu">
						<a class="dropdown-item" href="javascript:void(0)" role="menuitem"><i
							class="icon wb-user" aria-hidden="true"></i> Profile</a> <a
							class="dropdown-item" href="javascript:void(0)" role="menuitem"><i
							class="icon wb-payment" aria-hidden="true"></i> Billing</a> <a
							class="dropdown-item" href="javascript:void(0)" role="menuitem"><i
							class="icon wb-settings" aria-hidden="true"></i> Settings</a>
						<div class="dropdown-divider" role="presentation"></div>
						<a class="dropdown-item" href="javascript:void(0)" role="menuitem"><i
							class="icon wb-power" aria-hidden="true"></i> Logout</a>
					</div></li>
				<li class="nav-item dropdown"><a class="nav-link"
					data-toggle="dropdown" href="javascript:void(0)"
					title="Notifications" aria-expanded="false"
					data-animation="scale-up" role="button"> <i
						class="icon wb-bell" aria-hidden="true"></i> <span
						class="badge badge-pill badge-danger up">5</span>
				</a>
					<div class="dropdown-menu dropdown-menu-right dropdown-menu-media"
						role="menu">
						<div class="dropdown-menu-header">
							<h5>消息</h5>
							<span class="badge badge-round badge-danger">New 1</span>
						</div>

						<div class="list-group">
							<div data-role="container">
								<div data-role="content">
									<a class="list-group-item dropdown-item"
										href="javascript:void(0)" role="menuitem">
										<div class="media">
											<div class="pr-10">
												<i class="icon wb-order bg-red-600 white icon-circle"
													aria-hidden="true"></i>
											</div>
											<div class="media-body">
												<h6 class="media-heading">A new order has been placed</h6>
												<time class="media-meta"
													datetime="2018-06-12T20:50:48+08:00">5 hours ago</time>
											</div>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div></li>
				<li class="nav-item hidden-float"><a
					class="nav-link icon wb-power" href="#" role="button"> <span
						class="sr-only"></span>
				</a></li>
			</ul>
			<!-- End Navbar Toolbar Right -->
		</div>
		<!-- End Navbar Collapse -->

	</div>
</nav>
<div class="site-menubar">
	<div class="site-menubar-body">
		<div>
			<div>
				<ul class="site-menu" data-plugin="menu">
					<li class="site-menu-category"><i
						class="site-menu-icon wb-dashboard" aria-hidden="true"></i>首页</li>
					<li class="site-menu-item is-shown"><a class="animsition-link"
						href="#"> <span class="site-menu-title">首页</span>
					</a></li>
					<li class="site-menu-category"><i
						class="site-menu-icon wb-table" aria-hidden="true"></i>课程管理</li>
					<li class="site-menu-item is-shown"><a class="animsition-link"
						href="#"> <span class="site-menu-title">开班</span>
					</a></li>
					<li class="site-menu-item is-shown"><a class="animsition-link"
						href="#"> <span class="site-menu-title">开班</span>
					</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="site-menubar-footer"></div>
</div>