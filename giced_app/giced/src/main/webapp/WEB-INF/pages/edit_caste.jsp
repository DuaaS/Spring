<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Caste</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
    <script>
    function validateform(){  
		var caste_name=document.CasteForm.caste_name.value;  
		
		if (caste_name==null || caste_name==""){  
			  alert("Caste Name can't be blank.");  
			  return false;  
		}
	}  
    </script>
</head>
<body>

<c:url var="post_url"  value="/castes/edit" />
<form:form action="${post_url}" modelAttribute="caste" method="post" 
 class="form-horizontal" name="CasteForm" onsubmit="return validateform()">
    			<div class="row" >
	    		<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Edit Caste</legend>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="caste_id">
				                    <spring:message text="Caste Id"/>
				                </form:label>
				              	<form:input path="caste_id" name="caste_id" class="form-control" readonly="true"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="caste_name">
				                    <spring:message text="Caste"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="caste_name" name="caste_name" class="form-control required"/>
				            </div>
			          	</div>
				      	<c:if test="${not empty errorMsg}">
    							<spring:message text="${errorMsg}"/>
    						</c:if>
				      	<div class="form-group">
				            <div class="col-sm-5 col-sm-offset-1">
				              <div class="pull-left">
				                <button type="submit" class="btn btn-primary">SAVE</button>
				                <a class="btn btn-default" href="<c:url value="/castes"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>