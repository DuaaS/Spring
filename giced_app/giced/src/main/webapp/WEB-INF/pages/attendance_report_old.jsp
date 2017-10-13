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

	 /* function search_data(){
		var course = $("#course").val();
		var subject=$("#subject").val();
		var faculty=$("#faculty").val();
		var payment=$("#payment_check").val();
		
		 $.getJSON(
	             "searchData.json", 
	             {course_id: course, subject_id: subject, faculty_id: faculty, payment_check: payment_check},
	             function(data) {
	            	 alert(data);
	            	 var html = '<tbody>';
                     var len = data.length;
                     for(var i=0; i<len; i++){
                    	  html +='<tr><td>'+data[i].assignment_id+'</td>'+
                    	  			'<td>'+data[i].course+'</td>'+
                    	  			'<td>'+data[i].subject+'</td>'+
                    	  			'<td>'+data[i].faculty+'</td>'+
                    	  			'<td>'+data[i].completed_hours+'</td>'+
                    	  			'<td>'+data[i].assigned_hours+'</td>'+
                    	  			'<td>'+data[i].pending_hours+'</td>'+
                    	  			'<td>'+data[i].is_completed+'</td>'+
                    	  			'<td>'+data[i].payment_check+'</td></tr>';
                    	  			
                      }
                     html +='</tbody>';
                     $('#example').append(html);
	             } 
	          );
	}  */
	 
	 function search_data() {

		var course = $("#course").val();
		var subject=$("#subject").val();
		var faculty=$("#faculty").val();
		var payment=$("#payment_check").val();

	        $.ajax({
	            url : 'searchData.json',
	            type: 'GET',
	            dataType:'json',
	            data : {
	                "course_id" : course, "subject_id" : subject, "faculty_id" : faculty, "payment_check":payment_check
	            }, //here you send the daterange over an Ajax request and by default it's sended with a GET method
	            success : function(data) {
	                //alert(data); //here you will see an alert displaying the callback result coming from your spring controller
	                alert("Request succeeded!");
	                alert(data);
	                $('#example').bootstrapTable('load', data);
	            },

	            error : function(xhr, ajaxOptions, thrownError) {
	                if (xhr.status == 404) {
	                    alert(thrownError);
	                }
	            }

	        });
	    }
	
	

</script>

</head>
<body>
	
	<div class="container">
	<div class="row">
		
        
        <div class="col-md-12">

    	<fieldset>
      	<legend>Attendance Report</legend>
           <div class="form-group">
	          <div class="col-sm-5">
	            	<label>Course</label>
	            	<select class="form-control" id="course" name="course">
		            <option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listCourse}">
					       <option value="${list.course_id}">${list.course_name}</option> 
					   </c:forEach>
					</select>
	            </div>
	            <div class="col-sm-5">
	            	<label>Subject</label>
				  	 <select class="form-control" id="subject" name="subject" > 
				  	 	<option value="NONE" label="--- Select ---" />
				  	 	<c:forEach var="list" items="${listSubject}">
					       <option value="${list.subject_id}">${list.subject_name}</option> 
					   </c:forEach>
					</select>
	            </div>
	      </div>
	      <div class="form-group">
		      <div class="col-sm-5">
		            <label>Faculty</label>
					<select class="form-control" id="faculty" name="faculty"> 
					<option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listFaculty}">
					       <option value="${list.faculty_id}">${list.faculty_firstname} ${faculty_lastname}</option> 
					   </c:forEach>
					</select>
		      </div>   
		       <div class="col-sm-5">
		      		<label>Payment</label>
					<select  class="form-control" id="payment_check" name="payment_check" > 
						<option value="NONE" label="--- Select ---" />
						<option value="Done" label="Done" />
						<option value="Not Done" label="Not Done" />
					</select>
		      </div>   
	      </div>
	      <div class="form-group"></div>
	    <div class="form-group">
            <div class="col-sm-12">
              <div class="pull-right">
              	<%-- <a class="btn btn-primary" href="<c:url value="/searchData.json"/>">SEARCH</a> --%>
              	<a class="btn btn-primary" onclick="search_data()">SEARCH</a>
				<!-- <button type="submit" class="btn btn-primary" onclick="search_data()">SEARCH</button> -->               
				<c:if test="${role == '[ROLE_SUPER_ADMIN]'}"><a class="btn btn-default" href="<c:url value="/cancelSuperAdmin"/>">CANCEL</a></c:if>
				<c:if test="${role == '[ROLE_ADMIN]'}"><a class="btn btn-default" href="<c:url value="/cancelAdmin"/>">CANCEL</a></c:if>
              </div>
            </div>
          </div>
	   </fieldset>
	   
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
		                	<th>Completed?</th>
		                	<th>Payment</th>

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
						    <td>${list.payment_check}</td>
						</tr>
						</c:forEach>
                   </tbody>
				</table>   
			   
          </div>
           
          <div class="form-group">
            <div class="col-sm-12">
              <div class="pull-right">
                <a href="<c:url value='/export_excel'/>" class="btn btn-primary">Export to Excel</a>
                <a href="<c:url value='/export_pdf'/>" class="btn btn-primary">Export to PDF</a>
              </div>
            </div>
          </div>
        </c:if> 

       
          
        </div>
	</div>
	</div>
</body>
</html>