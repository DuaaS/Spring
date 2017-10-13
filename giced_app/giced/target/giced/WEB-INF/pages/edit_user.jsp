<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />

    <script>  
	function validateform(){  
		var user_name=document.UserForm.user_name.value;  
		var user_confirmpassword=document.UserForm.user_confirmpassword.value;
		var role_id=document.UserForm.role_id.value;  
		  
		if (user_name==null || user_name==""){  
			  alert("Username can't be blank.");  
			  return false;  
		}
		 
		if (user_password!=user_confirmpassword){  
			  alert("Confirm Password must be same as Password.");  
			  return false;  
		}
		if (role_id==null || role_id=="" || role_id=="NONE"){  
			  alert("Please select a Role.");  
			  return false;  
		}
	  
	}  
	  

</script>
</head>
<body>
<c:url var="role" value="SUPER_ADMIN"/>
<c:url var="post_url"  value="/users/edit/${role}" />
<form:form action="${post_url}" modelAttribute="user" method="post" 
class="form-horizontal" name="UserForm" onsubmit="return validateform()">
			<div class="row" >
	    		<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Edit User</legend>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="user_name">
				                    <spring:message text="Username"/>
				                </form:label>
				              	<form:input path="user_name" name="user_name" class="form-control" readonly="true"/>
				            </div>
			          	</div>
			          	<form:hidden path="user_password"/>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="role_id">
				                    <spring:message text="Role"/><span class="required">*</span>
				                </form:label>
				                <br/>
				                <form:select  path="role_id" name="role_id" class="form-control required">
									<form:option value="NONE" label="--- Select ---" />
									<c:forEach var="list" items="${listRole}">
								       <form:option value="${list.role_id}">${list.role_name}</form:option> 
								   	</c:forEach>
								</form:select>
				            </div>
				      	</div>
				      	<div class="form-group">
				            <div class="col-sm-5 col-sm-offset-1">
				              <div class="pull-left">
				                <button type="submit" class="btn btn-primary">SAVE</button>
				                <a class="btn btn-default" href="<c:url value="/users"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>