<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Appointment Type</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
    <script>
    function validateform(){  
		var appointment_id=document.ApptForm.appointment_id.value;  
		var appointment_name=document.ApptForm.appointment_name.value;  
		
		if (appointment_id==null || appointment_id==""){  
		  alert("Appointment Id can't be blank.");  
		  return false;  
		}
		if (appointment_name==null || appointment_name==""){  
			  alert("Appointment Type can't be blank.");  
			  return false;  
		}
	}  
    </script>
</head>
<body>

<c:url var="post_url"  value="/appointments/add" />
<form:form action="${post_url}" modelAttribute="appointment_type" method="post" 
class="form-horizontal" name="ApptForm" onsubmit="return validateform()">
<div class="row" >
	    		<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Add New Appointment Type</legend>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="appointment_id">
				                    <spring:message text="Appointment Id"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="appointment_id" name="appointment_id" class="form-control required" />
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="appointment_name">
				                    <spring:message text="Appointment Type"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="appointment_name" name="appointment_name" class="form-control required"/>
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
				                <a class="btn btn-default" href="<c:url value="/appointments"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>