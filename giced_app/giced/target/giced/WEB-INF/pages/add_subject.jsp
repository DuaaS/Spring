<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Subject</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
    <script>
    function validateform(){  
		var subject_id=document.SubjectForm.subject_id.value;  
		var subject_name=document.SubjectForm.subject_name.value;  
		var subject_duration=document.SubjectForm.subject_duration.value;
		
		if (subject_id==null || subject_id==""){  
		  alert("Subject Id can't be blank.");  
		  return false;  
		}
		if (subject_name==null || subject_name==""){  
			  alert("Subject can't be blank.");  
			  return false;  
		}
		if (inNan(subject_duration)){  
			  alert("Please enter valid Duration.");  
			  return false;  
			}
	}  
    </script>
</head>
<body>

<c:url var="post_url"  value="/subjects/add" />
<form:form action="${post_url}" modelAttribute="subject" method="post" 
class="form-horizontal" name="SubjectForm" onsubmit="return validateform()" >
			<div class="row" >
	    		<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Add New Subject</legend>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="subject_id">
				                    <spring:message text="Subject Id"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="subject_id" name="subject_id" class="form-control required"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="subject_name">
				                    <spring:message text="Subject"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="subject_name" name="subject_name" class="form-control required"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="subject_duration">
				                    <spring:message text="Duration"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="subject_duration" name="subject_duration" class="form-control required"/>
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
				                <a class="btn btn-default" href="<c:url value="/subjects"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>