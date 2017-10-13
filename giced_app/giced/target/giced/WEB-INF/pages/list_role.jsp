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
<title>Role</title>
<jsp:include page="fragments/super_admin_header.jsp" />

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
				<td><h4>Role</h4></td>
				<td style="text-align: right;"><a href="<c:url value='/add_role'/>" class="btn btn-primary">ADD</a></td>
		    </tr>
    	</table>
       <c:if test="${!empty listRole}">
        <div class="table-responsive">
        	
              <table id="example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
                    <thead>
                    <tr>
	                   	<th>ID</th>
	                	<th>Role</th>
                		<th>Description</th>
                        <th>Edit</th>
		                <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
    					<c:forEach items="${listRole}" var="role">
			                <tr>
			                	<td>${role.role_id}</td>
			                	<td>${role.role_name}</td>
                    			<td>${role.role_description}</td>
			                    <td><p data-placement="top" data-toggle="tooltip" title="Edit">
			                    <a class="btn btn-primary btn-xs" href="<c:url value='/editRole/${role.role_id}'/>" ><span class="glyphicon glyphicon-pencil"></span></a></p></td>
			                    <td><p data-placement="top" data-toggle="tooltip" title="Delete">
			                    <a class="btn btn-danger btn-xs" href="<c:url value='/removeRole/${role.role_id}'/>" ><span class="glyphicon glyphicon-trash"></span></a></p></td>
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
