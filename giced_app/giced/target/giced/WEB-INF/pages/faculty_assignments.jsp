<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty Assignments</title>
<jsp:include page="fragments/faculty_header.jsp" />

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/dataTables.bootstrap.min.css" rel="stylesheet"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	  $('#example').DataTable();
	});
</script>

</head>
<body>
	
	<div class="container">
	<div class="row">
		
        
        <div class="col-md-12">
        <table width="100%">
			<tr>
				<td><h4>Course/Subject Assignments</h4></td>
		    </tr>
    	</table>
       <c:if test="${!empty listAssignment}">
        <div class="table-responsive">
        	
              <table id="example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
				<thead>                   
                    <tr>
	                   	<th>ID</th>
	                	<th>Course</th>
	                	<th>Subject</th>
	                	<th>Assigned Duration</th>
	                	<th>Pending Duration</th>
	                	<th>Start Date</th>
	                	<th>End Date</th>
                    </tr>
                 </thead>
                 <tbody>
    					<c:forEach items="${listAssignment}" var="assign">
			                <tr>
			                	<td>${assign.assignment_id}</td>
			                    <td>
				                    <c:forEach items="${listCourse}" var="course">
				                    <c:if test = "${assign.course_id == course.course_id}">
				           				 ${course.course_name}
				         			</c:if>
				         			</c:forEach>
			         			</td>
			         			<td>
				                    <c:forEach items="${listSubject}" var="sub">
				                    <c:if test = "${assign.subject_id == sub.subject_id}">
				           				 ${sub.subject_name}
				         			</c:if>
				         			</c:forEach>
			         			</td>
			         			<td>${assign.assigned_duration}</td>
			         			<td>${assign.pending_duration}</td>
			         			<fmt:formatDate value="${assign.start_date}" pattern="dd-MM-yyyy" var="start_date" />
			         			<td>${start_date}</td>
			         			<fmt:formatDate value="${assign.end_date}" pattern="dd-MM-yyyy" var="end_date" />
			         			<td>${end_date}</td>
			                </tr>
            			</c:forEach>
				    </tbody>
				</table>   
			   
          </div>
          </c:if>   
        </div>
	</div>
</body>
</html>