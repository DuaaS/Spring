<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false"%>
<html>
	<head>
		<title>GICED-Login</title>
		<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
		<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'> 
		<link href='resources/core/css/login.css' rel='stylesheet' type='text/css'>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
		<script>
			function validateform(){  
				var user_name=document.LoginForm.username.value;  
				var user_password=document.LoginForm.password.value;  
						  
				if (user_name==null || user_name==""){  
				  alert("Username can't be blank.");  
				  return false;  
				}
				if (user_password==null || user_password==""){  
					  alert("Password can't be blank.");  
					  return false;  
				}				  
			}  
		</script>
	</head>
	<body>

		<div class="text-center" style="padding:50px 0">
			<div class="logo">login</div>
			<!-- Main Form -->
			<div class="login-form-1">
				<c:url var="loginUrl"  value="/login" /> 
				<%-- <c:url value="/j_spring_security_check" var="loginUrl" /> --%> 
				<%-- <c:url valvalue="<%=request.getContextPath()%>/login" var="loginUrl" /> --%>
				<form:form action="${loginUrl}"  method="post" 
				id="login-form" class="text-left" name="LoginForm" onsubmit="return validateform()">
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
					<div class="login-form-main-message"></div>
					<div class="main-login-form">
						<div class="login-group">
							<div class="form-group">
								<label for="lg_username" class="sr-only">Username</label>
								<input type="text" class="form-control"  name="username" placeholder="username"/>
							</div>
							<div class="form-group">
								<label for="lg_password" class="sr-only">Password</label>
								<input type="password" class="form-control" name="password" placeholder="password"/>
							</div>
						</div>
						<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
					</div>
					<c:if test="${not empty errorMsg}">
    					<div class="alert alert-danger">
    							<c:out value="${errorMsg}"/>
    						</div>
    				</c:if>
    				<c:if test="${not empty logoutMsg}">
						<div class="alert alert-success">
					    	<c:out value="${logoutMsg}"/>
					 	</div>
					</c:if>
					 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form:form>
			</div>
			<!-- end:Main Form -->
		</div>
	</body>
</html>



	