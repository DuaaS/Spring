<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit esignation</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
    <script>
    function validateform(){
	    var designation_name=document.DesignForm.designation_name.value;  
		
		if (designation_name==null || designation_name==""){  
			  alert("Designation Name can't be blank.");  
			  return false;  
		}
	}  
    </script>
</head>
<body>

<c:url var="post_url"  value="/designations/edit" />
<form:form action="${post_url}" modelAttribute="designation" method="post" 
 class="form-horizontal" name="DesignForm" onsubmit="return validateform()">
	    <div class="row" >
<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Edit Designation</legend>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="designation_id">
				                    <spring:message text="Designation Id"/>
				                </form:label>
				              	<form:input path="designation_id" name="designation_id" class="form-control" readonly="true"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="designation_name">
				                    <spring:message text="Designation"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="designation_name" name="designation_name" class="form-control required"/>
				            </div>
			          	</div>
				      	<c:if test="${not empty errorMsg}">
    							<spring:message text="${errorMsg}"/>
    						</c:if>
				      	<div class="form-group">
				            <div class="col-sm-5 col-sm-offset-1">
				              <div class="pull-left">
				                <button type="submit" class="btn btn-primary">SAVE</button>
				                <a class="btn btn-default" href="<c:url value="/designations"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>
