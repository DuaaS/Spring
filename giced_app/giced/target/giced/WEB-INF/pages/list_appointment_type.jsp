<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment Types</title>
<c:if test="${user_role == '[ROLE_SUPER_ADMIN]'}">
	<jsp:include page="fragments/super_admin_header.jsp" />
</c:if>
<c:if test="${user_role == '[ROLE_ADMIN]'}">
	<jsp:include page="fragments/admin_header.jsp" />
</c:if>

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
				<td><h4>Appointment Type</h4></td>
				<td style="text-align: right;"><a href="<c:url value='/add_appointment'/>" class="btn btn-primary">ADD</a></td>
		    </tr>
    	</table>
    	<%--  <div>${user_role}</div> --%>
       <c:if test="${!empty listAppts}">
        <div class="table-responsive">
        	
              <table id="example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
                  <thead>
                    <tr>
	                   	<th>ID</th>
	                	<th>Appointment Type</th>
	                	<th>Edit</th>
	                	<th>Delete</th>
                    </tr>
                   </thead>
                   <tbody>
    					<c:forEach items="${listAppts}" var="appt">
			                <tr>
			                	<td>${appt.appointment_id}</td>
			                    <td>${appt.appointment_name}</td>
			                    <td><p data-placement="top" data-toggle="tooltip" title="Edit"><a class="btn btn-primary btn-xs" href="<c:url value='/editAppointment/${appt.appointment_id}'/>" ><span class="glyphicon glyphicon-pencil"></span></a></p></td>
			                    <td><p data-placement="top" data-toggle="tooltip" title="Delete"><a class="btn btn-danger btn-xs" href="<c:url value='/removeAppointment/${appt.appointment_id}'/>" ><span class="glyphicon glyphicon-trash"></span></a></p></td>
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