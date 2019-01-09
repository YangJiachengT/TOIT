<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<nav class="nav-main">
	<ul class="uk-nav uk-nav-default" uk-nav>
		<li><span uk-icon="icon: table"></span>&nbsp;菜单</li>
		<li class="uk-nav-divider"></li>
		
		<li class="<c:if test="${active == 'home' }" >uk-active</c:if>"><a href="#">首页</a></li>
		
		<li class="<c:if test="${active == 'log' }" >uk-active</c:if>"><a href="#">日志查询</a></li>
		
		<li class="<c:if test="${active == 'course' }" >uk-active</c:if>"><a href="course" type="button">课程管理</a>
			<div uk-dropdown="pos: right-center">
				<ul class="uk-nav uk-dropdown-nav">
					<li><a href="#">开班</a></li>
					<li><a href="#">Item</a></li>
					<li><a href="#">Item</a></li>
					<li><a href="#">Item</a></li>
				</ul>
			</div></li>
			
		<li class="<c:if test="${active == 'question' }" >uk-active</c:if>"><a href="#" type="button">题库管理</a>
			<div uk-dropdown="pos: right-center">
				<ul class="uk-nav uk-dropdown-nav">
					<li><a href="#">Item</a></li>
					<li><a href="#">Item</a></li>
					<li><a href="#">Item</a></li>
					<li><a href="#">Item</a></li>
				</ul>
			</div></li>
			
		<li class="<c:if test="${active == 'user' }" >uk-active</c:if>"><a href="#">用户管理</a></li>
		
		<li><a href="#">5</a></li>
		
		<li class="uk-nav-divider"></li>
		<li><span uk-icon="icon: arrow-left"></span><span><a
				href="#">首页</a></span></li>
	</ul>
</nav>