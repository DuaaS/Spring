<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
<title>GICED</title>
<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/">GICED</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="<c:url value="/login"/>">Login</a></li>
			</ul>
		</div>
	</div>
</nav>
