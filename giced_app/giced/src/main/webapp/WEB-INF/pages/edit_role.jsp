<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Role</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />

    <script>
    function validateform(){  
		var role_name=document.RoleForm.role_name.value;  
		var role_description=document.RoleForm.role_description.value;  
				  
		if (role_name==null || role_name==""){  
			  alert("Role Name can't be blank.");  
			  return false;  
		}
		if (role_description==null || role_description==""){  
			  alert("Role Description can't be blank.");  
			  return false;  
		}
		  
	}  
    </script>
</head>
<body>

<c:url var="post_url"  value="/roles/edit" />
<form:form action="${post_url}" modelAttribute="role" method="post" 
class="form-horizontal" name="RoleForm" onsubmit="return validateform()" >
    <div class="row" >
<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Edit Role</legend>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="role_id">
				                    <spring:message text="Role Id"/>
				                </form:label>
				              	<form:input path="role_id" name="role_id" class="form-control" readonly="true"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="role_name">
				                    <spring:message text="Role"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="role_name" name="role_name" class="form-control required"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="role_description"><span class="required">*</span>
				                    <spring:message text="Role Description"/>
				                </form:label>
				              	<form:input path="role_description" name="role_description" class="form-control required"/>
				            </div>
			          	</div>
			          	
				      	<c:if test="${not empty errorMsg}">
    							<spring:message text="${errorMsg}"/>
    						</c:if>
				      	<div class="form-group">
				            <div class="col-sm-5 col-sm-offset-1">
				              <div class="pull-left">
				                <button type="submit" class="btn btn-primary">SAVE</button>
				                <a class="btn btn-default" href="<c:url value="/roles"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>