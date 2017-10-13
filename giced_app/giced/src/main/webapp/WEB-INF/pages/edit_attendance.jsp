<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Attendance</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
$(document).ready(function(){
    var date=$('input[name="date"]'); //our date input has the name "date"
    //var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
      format: 'mm/dd/yyyy',
      //container: container,
      todayHighlight: true,
      autoclose: true,
    };
    date.datepicker(options);
   
  })
     
function validateform(){  
	
	var course_id=document.AttendanceForm.course_id.value;
	var subject_id=document.AttendanceForm.subject_id.value;
	var faculty_id=document.AttendanceForm.faculty_id.value;
	var assignment_id=document.AttendanceForm.assignment_id.value;
	var date=document.AttendanceForm.assigned_duration.value;
	var in_time=document.AttendanceForm.in_time.value;
	var out_time=document.AttendanceForm.out_time.value;
	var payment=document.AttendanceForm.payment_check.value;
	
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
	else  if (assignment_id=="NONE"){  
			  alert("Please select an Assignment Id.");  
			  return false;  
			}
	
	else if (date==null || date==""){  
		  alert("Please select Date.");  
		  return false;  
	}
	else if (in_time==null || in_time==""){  
		  alert("Please enter In-Time.");  
		  return false;  
	}
	else if (out_time==null || out_time==""){  
		  alert("Please enter Out-Time.");  
		  return false;  
	}
	else if(in_time>out_time){
		alert("Please select valid In-Time/Out-Time.");  
		  return false;  
	}
	else if (payment_check=="NONE"){  
		  alert("Please select Payment.");  
		  return false;  
	}
	
	
}   
    function get_subject(){
    	var course = $("#selectCourse").val();
    	$('select#selectSubject').empty();
    	 $.getJSON(
                 "getSubject1.json", 
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
    function get_faculty(){
    	var course = $("#selectCourse").val();
    	var subject=$("#selectSubject").val();
    	$('select#selectFaculty').empty();
    	 $.getJSON(
                 "getFaculty.json", 
                 {course_id: course, subject_id:subject},
                 function(data) {
                	  var html = '<option value="NONE" label="--- Select ---" />';
                      var len = data.length;
                      for(var i=0; i<len; i++){
                           html += '<option value="' + data[i].faculty_id + '">' + data[i].faculty_firstname+' '+data[i].faculty_lastname + '</option>';
                       }
                      $('select#selectFaculty').append(html);
                 }
              );
    } 
    
    function get_assignment(){
    	var course = $("#selectCourse").val();
    	var subject=$("#selectSubject").val();
    	var faculty=$("#selectFaculty").val();
    	$('select#selectAssignment').empty();
    	 $.getJSON(
                 "getAssignment.json", 
                 {course_id: course, subject_id: subject, faculty_id: faculty},
                 function(data) {
                	  var html = '<option value="NONE" label="--- Select ---" />';
                      var len = data.length;
                      for(var i=0; i<len; i++){
                           html += '<option value="' + data[i].assignment_id + '">' + data[i].assignment_id + '</option>';
                       }
                      $('select#selectAssignment').append(html);
                 }
              );
    } 
    
   
        
    </script>
</head>
<body>
<c:url var="post_url"  value="/attendances/edit" />
<form:form action="${post_url}" method="post" modelAttribute="attendance"
class="form-horizontal" name="AttendanceForm" onsubmit="return validateform()" >
<div class="row" >
    <div class="col-md-8 col-md-offset-1">
      <fieldset>
      	<legend>Attendance</legend>
      	
          
           <form:hidden path="id"/>
           <div class="form-group">
	          <div class="col-sm-5">
	            	<label>Course</label>
		            <select   name="course_id" class="form-control"  id="selectCourse" onchange="get_subject()"> 
					<option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listCourse}">
					       <option value="${list.course_id}">${list.course_name}</option> 
					   </c:forEach>
					</select>
	            </div>
	            
	          </div>
	          
	          <div class="form-group">
	          <div class="col-sm-5">
	            	<label>Subject</label>
				  	 <select name="subject_id" class="form-control"  id="selectSubject"  onchange="get_faculty()" > 
					</select>
					<%-- <form:input path="faculty_subcaste" id="hdnSubCaste" type="hidden" /> --%>
	            </div>
	          </div>
	          
	          
	           <div class="form-group">
	          <div class="col-sm-5">
	            	<label>Faculty</label>
				  	 <select name="faculty_id" class="form-control"  id="selectFaculty"  onchange="get_assignment()" > 
					</select>
	            </div>
	        </div>
	          
	          <div class="form-group">
            <div class="col-sm-5">
              <form:label path="assignment_id">Assignment Id</form:label>
				  	 <select name="assignment_id" class="form-control"  id="selectAssignment" > 
					</select>
            </div>
           </div>
           
          
          <div class="form-group">
          	 <div class="col-sm-5">
              <form:label path="date">
				 Date
			  </form:label>
			  <form:input path="date" name="date" class="form-control" id="date" value="${date}" type="text"/>
            </div> 
          </div>
          
          <div class="form-group">
          	 <div class="col-sm-2">
              <form:label path="in_time">
				 In Time
			  </form:label>
			 <form:input path="in_time" name="in_time" type="time" class="form-control"/>
            </div> 
            
            <div class="col-sm-2">
              <form:label path="out_time">
				Out Time
			  </form:label>
			  <form:input path="out_time" name="out_time" type="time" class="form-control"/>
			  
            </div> 
          </div>
          
         
          
          <div class="form-group">
	          <div class="col-sm-5">
	            	<form:label path="payment_check">
	            	Payment
	            	</form:label>
		            <form:select path="payment_check"  name="payment_check" class="form-control" > 
					<form:option value="NONE" label="--- Select ---" />
					<form:option value="Done" label="Done" />
					<form:option value="Not Done" label="Not Done" />
					</form:select>
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
                <a class="btn btn-default" href="<c:url value="/attendances"/>">CANCEL</a>
              </div>
            </div>
          </div>
          
      </fieldset>
	</div>
</div>
</form:form>
</body>
</html>















