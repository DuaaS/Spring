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

<script type="text/javascript">

('#exportPDF').onclick = function() {
	  val list=$('#attReport').val();
	  alert(list);
	 
    	 $.getJSON(
                 "export_pdf.json", 
                 {attReport: list},
                 function(data) {
                	 alert("Opening PDF.");
                 }
              );
    
    return false;
  }


	 /*  function export_pdf(){
		  alert("HELLO");
		  
		  val list=$('#attReport').val();
		  alert(list);
		 
	    	 $.getJSON(
	                 "export_pdf.json", 
	                 {attReport: list},
	                 function(data) {
	                	 alert("Opening PDF.");
	                 }
	              );
	}  
	  */
	 
	

</script>

</head>
<body>

<c:url var="post_url"  value="/attendance_report" />
<form:form action="${post_url}" method="post" modelAttribute="attReport"
class="form-horizontal" name="ReportForm"  >
<div class="row" >
    <div class="col-md-8 col-md-offset-1">
      <fieldset>
      	<legend>Reports</legend>
      	
           <div class="form-group">
	          <div class="col-sm-5">
	            	<label>Course</label>
		            <form:select path="course" class="form-control" > 
					<option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listCourse}">
					       <option value="${list.course_id}">${list.course_name}</option> 
					   </c:forEach>
					</form:select>
	            </div>
	            <div class="col-sm-5">
	            	<label>Subject</label>
				  	 <form:select path="subject" class="form-control" > 
				  	 	<option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listSubject}">
					       <option value="${list.subject_id}">${list.subject_name}</option> 
					   </c:forEach>
					</form:select>
					<%-- <form:input path="faculty_subcaste" id="hdnSubCaste" type="hidden" /> --%>
	            </div>
	          </div>
	        
	           <div class="form-group">
	          <div class="col-sm-5">
	            	<label>Faculty</label>
				  	 <form:select path="faculty" class="form-control"> 
				  	 	<option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listFaculty}">
					       <option value="${list.faculty_id}">${list.faculty_firstname} ${list.faculty_lastname}</option> 
					   </c:forEach>
					</form:select>
	            </div>
	             <div class="col-sm-5">
	            	<label>Completed</label>
		            <form:select path="is_completed" class="form-control" > 
					<option value="NONE" label="--- Select ---" />
					<option value="YES" label="YES" />
					<option value="NO" label="NO" />
					</form:select>
				</div>
	        </div>
	          

         
          <legend></legend>
          <!-- Command -->
          <div class="form-group">
            <div class="col-sm-12">
              <div class="pull-right">
                <button type="submit" class="btn btn-primary">SEARCH</button>
                <c:if test="${role == '[ROLE_SUPER_ADMIN]'}"><a class="btn btn-default" href="<c:url value="/cancelSuperAdmin"/>">CANCEL</a></c:if>
				<c:if test="${role == '[ROLE_ADMIN]'}"><a class="btn btn-default" href="<c:url value="/cancelAdmin"/>">CANCEL</a></c:if>
              </div>
            </div>
          </div>
          
          <div> ${msg}</div>
           <c:if test="${!empty listReport}">
        <div class="table-responsive">
        	
              <table  id="example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" >
                    <thead>
                    	<tr>
		                   	<th>Assignment Id</th>
		                	<th>Course</th>
		                	<th>Subject</th>
		                	<th>Faculty</th>
		                	<th>Completed Duration</th>
		                	<th>Assigned Duration</th>
		                	<th>Pending Duration</th>
		                	<th>Completed</th>

		                </tr>
                   </thead>
                   <tbody>
                   	
                    	<c:forEach items="${listReport}" var="list">
                    	<tr>
	    					<td>${list.assignment_id}</td>
					        <td>${list.course}</td>
					        <td>${list.subject}</td>
						    <td>${list.faculty}</td>
					        <td>${list.completed_hours}</td>
						    <td>${list.assigned_hours}</td>
						    <td>${list.pending_hours}</td>
						    <td>${list.is_completed}</td>
						</tr>
						</c:forEach>
                   </tbody>
				</table>   
			   
          </div>
           <input type="hidden" value="${listReport}" id="attReport" name="attReport">
          <div class="form-group">
            <div class="col-sm-12">
              <div class="pull-right">
                <%-- <a href="<c:url value='/export_pdf'/>" class="btn btn-primary">Export to PDF</a> --%>
                <a href="<c:url value='/export_pdf'/>" id="exportPDF" class="btn btn-primary">Download PDF</a>
                <a href="<c:url value='/export_excel'/>" class="btn btn-primary">Download Excel</a>
              </div>
            </div>
          </div>
        </c:if> 
      </fieldset>
	</div>
</div>


</form:form>


</body>
</html>