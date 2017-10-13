<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Course Details</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
</head>
<body>


<form:form class="form-horizontal" >
  <div class="row" >
    <div class="col-md-8 col-md-offset-1">
      <fieldset>
	      				<legend>Course Details</legend>
	      				<div class="form-group">
				            <div class="col-sm-4">
				            	<spring:message text="Institution Name: "/>
				              	<spring:message text="${course.institution_name}"/>
				            </div>
			          	</div>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<spring:message text="Course Id: "/>
				              	<spring:message text="${course.course_id}"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<spring:message text="Duration: "/>
				              	<spring:message text="${duration}"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<spring:message text="Title: "/>
				              	<spring:message text="${title}"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<spring:message text="Revision Year: "/>
				              	<spring:message text="${course.revision_year}"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<spring:message text="Semisters: "/>
				              	<spring:message text="${course.course_semister}"/>
				            </div>
			          	</div>
			          	
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<spring:message text="Subjects: "/><br/>
				            	<c:if test="${!empty listSubject }">
				              		<c:forEach var="list" items="${listSubject}">
								       <c:out value="${list}" /> <br/>
								   	</c:forEach>
								</c:if>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<spring:message text="No. of Hours: "/>
				              	<spring:message text="${course.course_hours}"/>
				            </div>
			          	</div>
	
				      	<div class="form-group">
            <div class="col-sm-5 col-sm-offset-1">
              <div class="pull-left">
                <a class="btn btn-default" href="<c:url value="/courses"/>">CANCEL</a>
              </div>
            </div>
          </div>
	      			</fieldset>
    </div><!-- /.col-lg-12 -->
</div><!-- /.row -->
	
</form:form>
</body>
</html>