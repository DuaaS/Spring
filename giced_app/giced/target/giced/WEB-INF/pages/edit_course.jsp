<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Course</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
    <script>
    function validateform(){  
		var institution_name=document.CourseForm.institution_name.value;  
		var course_name=document.CourseForm.course_name.value;
		var course_duration=document.CourseForm.course_duration.value;
		var course_title=document.CourseForm.course_title.value;
		var course_semister=document.CourseForm.course_semister.value;
		var course_subjects=document.CourseForm.course_subjects.value;
		var course_hours=document.CourseForm.course_hours.value;
		
		
		if (institution_name==null || institution_name==""){  
		  alert("Institution Name can't be blank.");  
		  return false;  
		}
	
		if (course_name==null || course_name==""){  
			  alert("Course Id can't be blank.");  
			  return false;  
		}
		if (course_duration=="NONE"){  
			  alert("Please select Duration.");  
			  return false;  
		}
		if (course_title=="NONE"){  
			  alert("Please select Title.");  
			  return false;  
		}
		if (course_semister=="0"){  
			  alert("Please select Semister.");  
			  return false;  
		}
		if (course_subjects==null || course_subjects==""){  
			  alert("Please select Subjects.");  
			  return false;  
		}
		if (isNaN(course_hours)){  
			  alert("No of Hours can't be blank.");  
			  return false;  
		}
	}  
    </script>
</head>
<body>

<c:url var="post_url"  value="/courses/edit" />
<form:form action="${post_url}" modelAttribute="course" method="post" 
class="form-horizontal" name="CourseForm" onsubmit="return validateform()" >
			<div class="row" >
	    		<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Edit Course</legend>
	      				<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="institution_name">
				                    <spring:message text="Institution Name"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="institution_name" name="institution_name" class="form-control required"/>
				            </div>
			          	</div>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="course_id">
				                    <spring:message text="Course Id"/>
				                </form:label>
				              	<form:input path="course_id" name="course_id" class="form-control" readonly="true"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="course_name">
				                    <spring:message text="Course Name"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="course_name" name="course_name" class="form-control required"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="course_duration">
				                    <spring:message text="Duration"/><span class="required">*</span>
				                </form:label>
				              	<form:select  path="course_duration" name="course_duration" class="form-control required">
									<form:option value="NONE" label="--- Select ---" />
									<c:forEach var="list" items="${listDuration}">
								       <form:option value="${list.duration_id}">${list.duration_name}</form:option> 
								   	</c:forEach>
								</form:select>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="course_title">
				                    <spring:message text="Title"/><span class="required">*</span>
				                </form:label>
				              	<form:select  path="course_title" name="course_title" class="form-control required">
									<form:option value="NONE" label="--- Select ---" />
									<c:forEach var="list" items="${listTitle}">
								       <form:option value="${list.title_id}">${list.title_name}</form:option> 
								   	</c:forEach>
								</form:select>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="revision_year">
				                    <spring:message text="Revision Year"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="revision_year" name="revision_year" class="form-control required"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="course_semister">
				                    <spring:message text="Semister"/><span class="required">*</span>
				                </form:label>
				              	<form:select path="course_semister" class="form-control required" name="course_semister" >
									<form:option value="0" label="--- Select ---" />
									<form:option value="4" label="4" />
									<form:option value="6" label="6" />
									<form:option value="8" label="8" />
								</form:select>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="course_subjects">
				                    <spring:message text="Subject"/><span class="required">*</span>
				                </form:label>
				              	<form:select multiple="multiple"  path="course_subjects" name="course_subjects" class="form-control required">
									<c:forEach var="list" items="${listSubject}">
								       <form:option value="${list.subject_id}">${list.subject_name}</form:option> 
								   	</c:forEach>
								</form:select>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="course_hours">
				                    <spring:message text="No. of Hours"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="course_hours" name="course_hours" class="form-control required"/>
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
				                <a class="btn btn-default" href="<c:url value="/courses"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>