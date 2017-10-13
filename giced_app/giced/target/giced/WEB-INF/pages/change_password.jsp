<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />

    <script>  
	function validateform(){  
		var user_password=document.UserForm.user_password.value;
		  
		if (user_password==null || user_password==""){  
			  alert("Password can't be blank.");  
			  return false;  
		}
		 
	}  
	  

</script>
</head>
<body>

<c:url var="post_url"  value="/users/edit/${role}" />
<form:form action="${post_url}" modelAttribute="user" method="post" 
class="form-horizontal" name="UserForm" onsubmit="return validateform()">
			<div class="row" >
	    		<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Change Password</legend>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="user_name">
				                    <spring:message text="Username"/>
				                </form:label>
				              	<form:input path="user_name" name="user_name" class="form-control" readonly="true" />
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="user_password">
				                    <spring:message text="Password"/><span class="required">*</span>
				                </form:label>
				              	<form:password path="user_password" name="user_password" class="form-control required" />
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="role_id">
				                    <spring:message text="Role"/>
				                </form:label>
				                <br/>
				                <form:input path="role_id" readonly="true"/>
				            </div>
				      	</div>
				      	<div class="form-group">
				            <div class="col-sm-5 col-sm-offset-1">
				              <div class="pull-left">
				                <button type="submit" class="btn btn-primary">SAVE</button>
				                <c:if test="${role == '[ROLE_SUPER_ADMIN]'}"><a class="btn btn-default" href="<c:url value="/cancelSuperAdmin"/>">CANCEL</a></c:if>
				                <c:if test="${role == '[ROLE_ADMIN]'}"><a class="btn btn-default" href="<c:url value="/cancelAdmin"/>">CANCEL</a></c:if>
				                <c:if test="${role == '[ROLE_FACULTY]'}"><a class="btn btn-default" href="<c:url value="/cancelFaculty"/>">CANCEL</a></c:if>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>