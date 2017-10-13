<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Role</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />

	<script>  
	function validateform(){  
		var role_id=document.RoleForm.role_id.value;  
		var role_name=document.RoleForm.role_name.value;  
		var role_description=document.RoleForm.role_description.value;  
				  
		if (role_id==null || role_id==""){  
		  alert("Role Id can't be blank.");  
		  return false;  
		}
		if (role_name==null || role_name==""){  
			  alert("Role Name can't be blank.");  
			  return false;  
		}
		if (role_description==null || role_description==""){  
			  alert("Role Description can't be blank.");  
			  return false;  
		}
		  
	}  
	function upper(){
		var role = document.getElementById("role_id"); 
        role.value=role.value.toUpperCase();
	}
	</script>
</head>
<body>

<c:url var="post_url"  value="/roles/add" />
<form:form action="${post_url}" modelAttribute="role" method="post" 
class="form-horizontal" name="RoleForm" onsubmit="return validateform()">
<div class="row" >
<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Add New Role</legend>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="role_id">
				                    <spring:message text="Role Id"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="role_id" id="role_id" name="role_id" class="form-control required" onfocusout="upper()"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="role_name">
				                    <spring:message text="Role Name"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="role_name" name="role_name" class="form-control required"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="role_description">
				                    <spring:message text="Role Description"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="role_description" name="role_description" class="form-control required"/>
				            </div>
			          	</div>
			      	
				      	<c:if test="${not empty errorMsg}">
    						<div class="alert alert-danger">
    							<c:out value="${errorMsg}"/>
    						</div>
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