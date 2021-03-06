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
<title>Attendance</title>
<jsp:include page="fragments/faculty_header.jsp" />
<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel=stylesheet type="text/css" />

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
				<td><h4>Attendance: ${faculty_name} </h4></td>
				<td style="text-align: right;"><a href="<c:url value='/add_attendance'/>" class="btn btn-primary">ADD</a></td>
		    </tr>
    	</table>
       <c:if test="${!empty listAttendance}">
        <div class="table-responsive">
        	
              <table id="example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
                   <thead>
                    <tr>
	                   	<th>Assignment Id</th>
		                	<th>Course</th>
		                	<th>Subject</th>
		                	<th>Date</th>
		                	<th>In_Time</th>
		                	<th>Out_Time</th>
		                	<th>Duration</th>
		                	<th>Payment</th>
                    </tr>
                    </thead>
                 	<tbody>
    					<c:forEach items="${listAssignment}" var="as">
	    					<c:forEach items="${listAttendance}" var="at">
	    						<c:if test="${as.assignment_id == at.assignment_id }">
					                <tr>
					                	<td>${at.assignment_id}</td>
					                	<td>
					                		<c:forEach items="${listCourse}" var="course">
							                    <c:if test = "${as.course_id == course.course_id}">
							           				 ${course.course_name}
							         			</c:if>
							         		</c:forEach>
					                	</td>
					                    <td>
					                		<c:forEach items="${listSubject}" var="sub">
							                    <c:if test = "${sub.subject_id == as.subject_id}">
							           				 ${sub.subject_name}
							         			</c:if>
							         		</c:forEach>
					                	</td>
					                	<fmt:formatDate value="${at.date}" pattern="dd-MM-yyyy" var="new_date" />
			         					<td>${new_date}</td>
						                <td>${at.in_time}</td>
						                <td>${at.out_time}</td>
						                <td>${at.completed_hours}</td>
						                <td>${at.payment_check}</td>
					                    
					                </tr>
					            </c:if>   
	            			</c:forEach>
	            		</c:forEach>
				    </tbody>
				</table>   
			   
          </div>
          </c:if>   
        </div>
	</div>
</body>
</html>