<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Faculty</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
$(document).ready(function(){
    var start_date=$('input[name="start_date"]'); //our date input has the name "date"
    var end_date=$('input[name="end_date"]'); //our date input has the name "date"
    //var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
      format: 'mm/dd/yyyy',
      //container: container,
      todayHighlight: true,
      autoclose: true,
    };
    start_date.datepicker(options);
    end_date.datepicker(options);
  })
     
function validateform(){  
	
	var assignment_id=document.AssignmentForm.assignment_id.value;  
	var course_id=document.AssignmentForm.course_id.value;
	var subject_id=document.AssignmentForm.subject_id.value;
	var faculty_id=document.AssignmentForm.faculty_id.value;
	var assigned_duration=document.AssignmentForm.assigned_duration.value;
	var start_date=document.AssignmentForm.start_date.value;
	var end_date=document.AssignmentForm.end_date.value;
	
	  
	if (assignment_id==null || assignment_id==""){  
	  alert("Assignment Id can't be blank.");  
	  return false;  
	}
	else if (course_id=="NONE"){  
		  alert("Please select a Course.");  
		  return false;  
	}
	else if (subject_id=="NONE"){  
		  alert("Please select a Subject.");  
		  return false;  
	}
	else if (faculty_id=="NONE"){  
		  alert("Please select a Faculty.");  
		  return false;  
	}
	else if (isNaN(assigned_duration)){  
		  alert("Please enter valid Assigned Hours.");  
		  return false;  
	}
	else if (start_date==null || start_date==""){  
		  alert("Please select Start Date.");  
		  return false;  
	}
	else if (end_date==null || end_date==""){  
		  alert("Please select End Date.");  
		  return false;  
	}
	else if(end_date<start_date){
		alert("Please select valid Dates");  
		  return false; 
	}
	$('#hdnPending').val(assigned_duration);
  
}   
    function get_subject(){
    	var course = $("#selectCourse").val();
    	$('select#selectSubject').empty();
    	 $.getJSON(
                 "getSubject.json", 
                 {course_id: course},
                 function(data) {
                	  var html = '<option value="NONE" label="--- Select ---" />';
                      var len = data.length;
                      for(var i=0; i<len; i++){
                           html += '<option value="' + data[i].subject_id + '">' + data[i].subject_name + '</option>';
                       }
                      $('select#selectSubject').append(html);
                 }
              );
    } 
        
    </script>
</head>
<body>
<c:url var="post_url"  value="/assignments/add" />
<form:form action="${post_url}" method="post" modelAttribute="assignment"
class="form-horizontal" name="AssignmentForm" onsubmit="return validateform()" >
<div class="row" >
    <div class="col-md-8 col-md-offset-1">
      <fieldset>
      	<legend>Course-Faculty Assignment</legend>
      	
          <div class="form-group">
            <div class="col-sm-4">
              <form:label path="assignment_id">
			  	Assignment Id<span class="required">*</span>
			  </form:label>
			  <form:input path="assignment_id" name="assignment_id" placeholder="assignment id" class="form-control required"/>
            </div>
           </div>
           
           <div class="form-group">
	          <div class="col-sm-5">
	            	<form:label path="course_id">
					 Course<span class="required">*</span>
				  	</form:label>
		            <form:select  path="course_id" name="course_id" class="form-control required"  id="selectCourse" onchange="get_subject()"> 
					<form:option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listCourse}">
					       <form:option value="${list.course_id}">${list.course_name}</form:option> 
					   </c:forEach>
					</form:select>
	            </div>
	            <div class="col-sm-5">
	            	<form:label path="subject_id">
					 Subject<span class="required">*</span>
				  	</form:label>
				  	 <select name="subject_id" class="form-control required"  id="selectSubject" ><!-- onchange="set_hdnSubCaste()" > -->
					</select>
					<%-- <form:input path="faculty_subcaste" id="hdnSubCaste" type="hidden" /> --%>
	            </div>
	          </div>
           
            <div class="form-group">
	          <div class="col-sm-5">
	            	<form:label path="faculty_id">
					 Faculty<span class="required">*</span>
				  	</form:label>
		            <form:select  path="faculty_id" name="faculty_id" class="form-control required" > 
					<form:option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listFaculty}">
					       <form:option value="${list.faculty_id}">${list.faculty_firstname} ${list.faculty_lastname}</form:option> 
					   </c:forEach>
					</form:select>
	            </div>
	        </div>
           
           <div class="form-group">
	           <div class="col-sm-3">
	              <form:label path="assigned_duration">
					 Assigned Hours<span class="required">*</span>
				  </form:label>
				 <form:input path="assigned_duration" name="assigned_duration" class="form-control"/>
	            </div> 
          </div>
          <div class="form-group">
          	 <div class="col-sm-5">
              <form:label path="start_date">
				 Start Date<span class="required">*</span>
			  </form:label>
			  <form:input path="start_date" name="start_date" class="form-control required" id="start_date" placeholder="MM/DD/YYYY" type="text"/>
            </div> 
          	<div class="col-sm-5">
             <form:label path="end_date">
				 End Date<span class="required">*</span>
			  </form:label>
			  <form:input path="end_date" name="end_date" class="form-control required" id="end_date" placeholder="MM/DD/YYYY" type="text"/>
            </div> 
          </div>
         
          <legend></legend>
		<c:if test="${not empty errorMsg}">
    		<div class="alert alert-danger">
    							<c:out value="${errorMsg}"/>
    		</div>
    	</c:if>
          
          <!-- Command -->
          <div class="form-group">
            <div class="col-sm-5 col-sm-offset-1">
              <div class="pull-left">
                <button type="submit" class="btn btn-primary">SAVE</button>
                <a class="btn btn-default" href="<c:url value="/assignments"/>">CANCEL</a>
              </div>
            </div>
          </div>
          
      </fieldset>
	</div>
</div>
</form:form>
</body>
</html>















