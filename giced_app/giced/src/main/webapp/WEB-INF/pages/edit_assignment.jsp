<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Faculty Assignment</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
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
	
	var course_id=document.FacultyForm.course_id.value;
	var subject_id=document.FacultyForm.subject_id.value;
	var faculty_id=document.FacultyForm.faculty_id.value;
	var assigned_duration=document.FacultyForm.assigned_duration.value;
	var start_date=document.FacultyForm.start_date.value;
	var end_date=document.FacultyForm.end_date.value;
	
	  
	if (course_id=="NONE"){  
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
	}else if(end_date<start_date){
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

<c:url var="post_url"  value="/assignments/edit" />
<form:form action="${post_url}" modelAttribute="assignment" method="post" 
class="form-horizontal" name="AssignmentForm" onsubmit="return validateform()">
	    <div class="row" >
	    		<div class="col-md-8 col-md-offset-1">
	 <fieldset>
      	<legend>Course-Faculty Assignment</legend>
      	
          <div class="form-group">
            <div class="col-sm-4">
              <form:label path="assignment_id">
			  	Assignment Id
			  </form:label>
			  <form:input path="assignment_id" name="assignment_id" placeholder="assignment id" class="form-control" readonly="true"/>
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
	           <div class="col-sm-2">
	              <form:label path="assigned_duration">
					 Assigned Hours<span class="required">*</span>
				  </form:label>
				 <form:input path="assigned_duration" name="assigned_duration" class="form-control required"/>
	            </div> 
          </div>
          <div class="form-group">
          	 <div class="col-sm-5">
              <form:label path="start_date">
				 Start Date<span class="required">*</span>
			  </form:label>
			  <form:input path="start_date" name="start_date" class="form-control" id="start_date" placeholder="MM/DD/YYYY" type="text" value="${start_date}"/>
            </div> 
          	<div class="col-sm-5">
             <form:label path="end_date">
				 End Date<span class="required">*</span>
			  </form:label>
			  <form:input path="end_date" name="end_date" class="form-control" id="end_date" placeholder="MM/DD/YYYY" type="text" value="${end_date}"/>
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
