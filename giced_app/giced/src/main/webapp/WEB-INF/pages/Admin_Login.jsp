<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
		<jsp:include page="fragments/admin_header.jsp"/>
	</head>

	<body>
	
		<div class="container">
		<c:if test="${not empty user_name}">
		Welcome! <spring:message text="${user_name}"/>
    	</c:if>		
    	</div>
		
	</body>
	</html>