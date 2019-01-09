<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% 
String path = "http://localhost:8080";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- uk css -->
<link rel="stylesheet" type="text/css" media="screen"
	href="/css/UK/uikit.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="/css/UK/uikit-rtl.min.css" />
	
<!-- bootstrap css -->
<link rel="stylesheet" href="/css/bootstrap/bootstrap.css">

<!-- bootstrap-table css -->
<link rel="stylesheet" href="/css/bootstrap-table/bootstrap-table.css">

<style>
	html, body {
		width: 100%;
		height: 100%;
	}
	
	body {
		opacity: 0;
		transition: 1s;
	}
	
	ul {
		list-style-type: none
	}
	
	header {
		background-color: #3f51b5;
		color: white;
		position: fixed;
		width: 100%;
		z-index: 9999
	}
	
	header .head {
		position: relative;
	}
	
	header .head span:first-of-type {
		display: inline-block;
		padding: 20px;
		font-size: 2.5rem;
	}
	
	header .head .admin {
		position: absolute;
		right: 50px;
		display: inline-block;
		padding: 20px;
		top: 50%;
		transform: translateY(-50%);
		font-size: 1.5rem;
		width: 200px;
		color: white;
		border: none
	}
	.main {
		height: 100%;
	}
	
	.main .nav-main {
		width: 150px;
		/* background: red; */
		position: fixed;
		padding-top: 50px;
		padding-left: 20px;
		z-index:9999
	}
	
	.uk-nav-default {
		font-size: 1.5rem;
	}
	
	.uk-nav li {
		margin-top: 15px
	}
	
	.table-main {
		width: 100%;
		height: auto;
		padding-right: 50px;
	}
	
	footer {
		width: 100%;
		position: fixed;
		bottom: 0;
		text-align: center;
		background: rgb(235, 233, 233);
		color: #000;
		z-index: 9999
	}
	.btn-primary{
		background-color:#FFF;
		color:#337ab7;
	}
</style>