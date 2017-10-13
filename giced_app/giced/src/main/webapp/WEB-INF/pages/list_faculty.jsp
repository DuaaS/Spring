<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Faculty</title>
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
<c:url var="user"  value="admin" />
<div class="container">
	<div class="row">
		
        
        <div class="col-md-12">
        <table width="100%">
			<tr>
				<td><h4>Faculty</h4></td>
				<td style="text-align: right;"><a href="<c:url value='/add_faculty'/>" class="btn btn-primary">ADD</a></td>
		    </tr>
    	</table>
       <c:if test="${!empty listFaculties}">
        <div class="table-responsive">
        	
              <table id="example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
                    <thead>
                    <tr>
	                   	<th>ID</th>
	                   	<th>Full Name</th>
		                <th>Mobile</th>
		                <th>Email</th>
		                <th>Show</th>
		                <th>Edit</th>
		                <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
    					<c:forEach items="${listFaculties}" var="faculty">
			                <tr>
			                	<td>${faculty.faculty_id}</td>
			                	<td>${faculty.faculty_abbreviation} ${faculty.faculty_firstname} ${faculty.faculty_middlename} ${faculty.faculty_lastname}</td>
                    			<td>${faculty.faculty_mobile}</td>
			         			<td>${faculty.faculty_email}</td>
         						<td><p data-placement="top" data-toggle="tooltip" title="Show">
			                    <a class="btn btn-primary btn-xs" href="<c:url value='/showFaculty/${faculty.faculty_id}'/>" ><span class="glyphicon glyphicon-plus-sign"></span></a></p></td>
			                    <td><p data-placement="top" data-toggle="tooltip" title="Edit">
			                    <a class="btn btn-primary btn-xs" href="<c:url value='/editFaculty/${faculty.faculty_id}/${user}'/>" ><span class="glyphicon glyphicon-pencil"></span></a></p></td>
			                    <td><p data-placement="top" data-toggle="tooltip" title="Delete">
			                    <a class="btn btn-danger btn-xs" href="<c:url value='/removeFaculty/${faculty.faculty_id}'/>" ><span class="glyphicon glyphicon-trash"></span></a></p></td>
			                </tr>
            			</c:forEach>
				    </tbody>
				</table>   
			  
          </div>
          
          </c:if>    
        </div>
	</div>
</div>
</body>
</html>	
