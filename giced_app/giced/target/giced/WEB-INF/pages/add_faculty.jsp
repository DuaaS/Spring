<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Faculty</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
$(document).ready(function(){
    var date_input=$('input[name="faculty_dob"]'); //our date input has the name "date"
    //var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
      format: 'mm/dd/yyyy',
      //container: container,
      todayHighlight: true,
      autoclose: true,
    };
    date_input.datepicker(options);
  })
     
function validateform(){  
	
	var faculty_id=document.FacultyForm.faculty_id.value;  
	var faculty_abbreviation=document.FacultyForm.faculty_abbreviation.value;
	var faculty_firstname=document.FacultyForm.faculty_firstname.value;
	var faculty_lastname=document.FacultyForm.faculty_lastname.value;
	var faculty_dob=document.FacultyForm.faculty_dob.value;
	var faculty_age=document.FacultyForm.faculty_age.value;
	var faculty_gender=document.FacultyForm.faculty_gender.value;
	var faculty_nationality=document.FacultyForm.faculty_nationality.value;
	var faculty_caste=document.FacultyForm.faculty_caste.value;
	var faculty_subcaste=document.FacultyForm.faculty_subcaste.value;
	var faculty_category=document.FacultyForm.faculty_category.value;
	var faculty_marital_status=document.FacultyForm.faculty_marital_status.value;
	
	var faculty_mobile=document.FacultyForm.faculty_mobile.value;
	var faculty_email=document.FacultyForm.faculty_email.value;
	var faculty_alt_email=document.FacultyForm.faculty_alt_email.value;
	
	var faculty_pan=document.FacultyForm.faculty_pan.value;
	var faculty_bank_name=document.FacultyForm.faculty_bank_name.value;
	var faculty_bank_account_no=document.FacultyForm.faculty_bank_account_no.value;
	var faculty_bank_branch=document.FacultyForm.faculty_bank_branch.value;
	var faculty_bank_ifsc=document.FacultyForm.faculty_bank_ifsc.value;
	
	var faculty_degree=document.FacultyForm.faculty_degree.value;
	var faculty_experience=document.FacultyForm.faculty_experience.value;
	var faculty_exp_type=document.FacultyForm.faculty_exp_type.value;
	var faculty_appointment_type=document.FacultyForm.faculty_appointment_type.value;
	var user_name=document.FacultyForm.user_name.value;
	
	var atposition=faculty_email.indexOf("@");  
	var dotposition=faculty_email.lastIndexOf("."); 
	
	var atposition_alt=faculty_alt_email.indexOf("@");  
	var dotposition_alt=faculty_alt_email.lastIndexOf("."); 
	  
	  
	if (faculty_id==null || faculty_id==""){  
	  alert("Faculty Id can't be blank.");  
	  return false;  
	}
	else if (faculty_abbreviation=="NONE"){  
		  alert("Please select an Abbreviation.");  
		  return false;  
	}
	else if (faculty_firstname==null || faculty_firstname==""){  
		  alert("First Name can't be blank.");  
		  return false;  
	}
	else if (faculty_lastname==null || faculty_lastname==""){  
		  alert("Last Name can't be blank.");  
		  return false;  
	}
	else if (faculty_dob==null || faculty_dob==""){  
		  alert("Please select Date of Birth.");  
		  return false;  
	}
	else if (isNaN(faculty_age)){  
		  alert("Age must be a number.");  
		  return false;  
	}
	else if (faculty_gender==null || faculty_gender=="" || faculty_gender=="NONE"){  
		  alert("Please select Gender.");  
		  return false;  
	}
	else if (faculty_nationality=="0"){  
		  alert("Please select Nationality.");  
		  return false;  
	}
	else if (faculty_caste=="NONE"){  
		  alert("Please select Caste.");  
		  return false;  
	}
	/* else if (faculty_subcaste=="NONE"){  
		  alert("Please select Sub-Caste.");  
		  return false;  
	} */
	else if (faculty_category=="NONE"){  
		  alert("Please select Category.");  
		  return false;  
	}
	else if (faculty_marital_status=="NONE"){  
		  alert("Please select Marital Status.");  
		  return false;  
	}

	else if (isNaN(faculty_mobile)){  
		  alert("Please enter valid Mobile Number.");  
		  return false;  
	}
	else if (atposition<1 || dotposition<atposition+2 || dotposition+2>=faculty_email.length){  
		  alert("Please enter a valid Email.");  
		  return false;  
		  }
	else if (atposition_alt<1 || dotposition_alt<atposition_alt+2 || dotposition_alt+2>=faculty_alt_email.length){  
		  alert("Please enter a valid Alternate Email.");  
		  return false;  
		  }
	else if (faculty_pan==null || faculty_pan==""){  
		  alert("PAN Number can't be blank.");  
		  return false;  
	}
	else if (faculty_bank_name==null || faculty_bank_name=="" || faculty_bank_account_no == "" || faculty_bank_name==null ||
			faculty_bank_branch==null || faculty_bank_branch=="" || faculty_bank_ifsc==null || faculty_bank_ifsc==""){  
		  alert("Please enter Bank Details.");  
		  return false;  
	}
	else if (faculty_degree==null || faculty_degree==""){  
		  alert("Degree can't be blank.");  
		  return false;  
	}else if (faculty_experience==null || faculty_experience==""){  
		  alert("Experience can't be blank.");  
		  return false;  
	}
	else if (faculty_appointment_type=="NONE"){  
		  alert("Please select Appointment Type.");  
		  return false;  
	}
	else if (user_name==null || user_name==""){  
		  alert("Please select Appointment Type.");  
		  return false;  
	}
  
}   
    function get_subcaste(){
    	var caste = $("#selectCaste").val();
    	$('select#selectSubCaste').empty();
    	 $.getJSON(
                 "getSubCaste.json", 
                 {caste_id: caste},
                 function(data) {
                	  var html = '<option value="NONE" label="--- Select ---" />';
                      var len = data.length;
                      for(var i=0; i<len; i++){
                           html += '<option value="' + data[i].subcaste_id + '">' + data[i].subcaste_name + '</option>';
                       }
                      $('select#selectSubCaste').append(html);
                 }
              );
    } 
    
  /*   function set_hdnSubCaste(){
    	var sc=$('#selectSubCaste').val;
    	document.getElementById("data").value=sc;
    } */
   
 
    
    </script>
</head>
<body>
<c:url var="post_url"  value="/faculties/add" />
<form:form action="${post_url}" method="post" modelAttribute="faculty"
class="form-horizontal" name="FacultyForm" onsubmit="return validateform()" >
<div class="row" >
    <div class="col-md-8 col-md-offset-1">
      <fieldset>
      	<legend>Personal Details</legend>
      	<!-- Faculty Id -->
          <div class="form-group">
            <div class="col-sm-4">
              <form:label path="faculty_id">
			  	Faculty Id<span class="required">*</span>
			  </form:label>
			  <form:input path="faculty_id" name="faculty_id" placeholder="faculty id" class="form-control required"/>
            </div>
           </div>
           
            <!-- Designation & Abbreviation -->
            <div class="form-group">
            <div class="col-sm-4">
              <form:label path="faculty_designation">
				 Designation
			  </form:label>
              <form:select  path="faculty_designation" name="faculty_designation" placeholder="designation" class="form-control">
				<form:option value="NONE" label="--- Select ---" />
					<c:forEach var="list" items="${listDesignation}">
				       <form:option value="${list.designation_id}">${list.designation_name}</form:option> 
				   </c:forEach>
				</form:select>
            </div>
            <!-- <div class="col-sm-2">
            </div> -->
            <div class="col-sm-4">
              <form:label path="faculty_abbreviation">
				 Abbreviation<span class="required">*</span>
			  </form:label>
              <form:select path="faculty_abbreviation" class="form-control required" name="faculty_abbreviation" placeholder="abbreviation">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="Mr." label="Mr." />
						<form:option value="Ms." label="Ms." />
						<form:option value="Mrs." label="Mrs." />
			  </form:select>
            </div>
          </div> 
          
          <!-- Full Name -->
          <div class="form-group">
          	<div class="col-sm-4">
              <form:label path="faculty_firstname">
				 First Name<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_firstname" name="faculty_firstname" class="form-control required" placeholder="first name"/>
            </div>
            <div class="col-sm-4">
              <form:label path="faculty_middlename">
				 Middle Name
			  </form:label>
			  <form:input path="faculty_middlename" name="faculty_middlename" class="form-control" placeholder="middle name"/>              
            </div>
            <div class="col-sm-4">
              <form:label path="faculty_lastname">
				 Last Name<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_lastname" name="faculty_lastname" class="form-control required" placeholder="last name"/>
            </div>            
          </div>
          
          <div class="form-group">
          	<!-- Date of Birth-->
             <div class="col-sm-4">
              <form:label path="faculty_dob">
				 Date of Birth<span class="required">*</span>
			  </form:label>
			  <form:input path="faculty_dob" name="faculty_dob" class="form-control required" id="date" placeholder="MM/DD/YYYY" type="text"/>
            </div> 
          	<!-- Age-->
            <div class="col-sm-4">
              <form:label path="faculty_age">
				 Age
			  </form:label>
              <form:input  path="faculty_age" name="faculty_age" class="form-control required" placeholder="age"/>
            </div> 
          </div>
          <!-- Gender-->  
         <div class="form-group">
          	<div class="col-sm-4">
          		<form:label path="faculty_gender">
				 Gender<span class="required">*</span>
			  	</form:label>
			  	<br/>
	            <label class="radio-inline"> <form:radiobutton path="faculty_gender" value="Male" />Male</label>
				<label class="radio-inline"> <form:radiobutton path="faculty_gender" value="Female" />Female</label>
            </div> 
          </div> 
          <!-- Nationality-->
          <div class="form-group"> 
          <div class="col-sm-4">
          		<form:label path="faculty_nationality">
				 Nationality<span class="required">*</span>
			  	</form:label>
			  	<form:select  path="faculty_nationality" name="faculty_nationality" class="form-control required" >
					<form:option value="0" label="--- Select ---" />
					<c:forEach var="list" items="${listCountries}">
					       <form:option value="${list.country_id}">${list.country_name}</form:option> 
					</c:forEach>
				</form:select>
			</div> 
          </div> 
          
          <!-- Caste, Sub-Caste & Category -->
          <div class="form-group">
	          <div class="col-sm-4">
	            	<form:label path="faculty_caste">
					 Caste<span class="required">*</span>
				  	</form:label>
		            <form:select  path="faculty_caste" name="faculty_caste" class="form-control required"  id="selectCaste" onchange="get_subcaste()"> 
					<form:option value="NONE" label="--- Select ---" />
						<c:forEach var="list" items="${listCaste}">
					       <form:option value="${list.caste_id}">${list.caste_name}</form:option> 
					   </c:forEach>
					</form:select>
	            </div>
	          <div class="col-sm-4">
	            	<form:label path="faculty_subcaste">
					 Sub-Caste<span class="required">*</span>
				  	</form:label>
				  	 <select name="faculty_subcaste" class="form-control required"  id="selectSubCaste" ><!-- onchange="set_hdnSubCaste()" > -->
					</select>
					<%-- <form:input path="faculty_subcaste" id="hdnSubCaste" type="hidden" /> --%>
	            </div>
	          <div class="col-sm-4">
            	<form:label path="faculty_category">
				 Category<span class="required">*</span>
			  	</form:label>
	            <form:select  path="faculty_category" name="faculty_category" class="form-control required">
				<form:option value="NONE" label="--- Select ---" />
					<c:forEach var="list" items="${listCategory}">
				       		<form:option value="${list.category_id}">${list.category_name}</form:option> 
				   	</c:forEach>
				</form:select>
            </div>
          </div>
          
           <!-- Marital Status-->
          <div class="form-group">
          <div class="col-sm-4">
            	<form:label path="faculty_marital_status">
				 Marital Status<span class="required">*</span>
			  	</form:label>
	            <form:select path="faculty_marital_status" class="form-control required" name="faculty_marital_status" placeholder="marital status">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="Single" label="Single" />
						<form:option value="Married" label="Married" />
						<form:option value="Divorced" label="Divorced" />
						<form:option value="Widowed" label="Widowed" />
				</form:select>
            </div>
          </div>
          
          <legend>Contact Details</legend>
          <!-- Address -->
          <div class="form-group">
           <div class="col-sm-10">
              <form:label path="faculty_building">
				 Building Name
			  	</form:label>
              <form:input path="faculty_building" name="faculty_building" class="form-control" placeholder="building name"/>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-10">
              <form:label path="faculty_street">
				Street Name
			  </form:label>
              <form:input path="faculty_street" name="faculty_street" class="form-control" placeholder="street name"/>
            </div>
          </div>
          <div class="form-group">
          	<div class="col-sm-5">
              <form:label path="faculty_area">
				 Area
			  </form:label>
              <form:input path="faculty_area" name="faculty_area" class="form-control" placeholder="area"/>
            </div>
            <div class="col-sm-5">
              <form:label path="faculty_station">
				 Station
			  </form:label>
              <form:input path="faculty_station" name="faculty_station" class="form-control" placeholder="station"/>
            </div>
            <div class="col-sm-2">
              <form:label path="faculty_pincode">
				 Pincode
			  </form:label>
              <form:input path="faculty_pincode" name="faculty_pincode" class="form-control" placeholder="pincode"/>
            </div>
          </div>
          <div class="form-group">
          	<div class="col-sm-5">
              <form:label path="faculty_city">
				 City
			  </form:label>
              <form:input path="faculty_city" name="faculty_city" class="form-control" placeholder="area"/>
            </div>
            <div class="col-sm-5">
              <form:label path="faculty_state">
				 State
			  </form:label>
              <form:input path="faculty_state" name="faculty_state" class="form-control" placeholder="station"/>
            </div>
          </div>
          
          <!-- Contact Numbers -->
          <div class="form-group">
          	<div class="col-sm-4">
              <form:label path="faculty_mobile">
				 Mobile No.<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_mobile" name="faculty_mobile" class="form-control required" placeholder="mobile number"/>
            </div>
            <div class="col-sm-4">
              <form:label path="faculty_alt_mobile">
				 Alternate Mobile No.
			  </form:label>
              <form:input path="faculty_alt_mobile" name="faculty_alt_mobile" class="form-control" placeholder="alternate mobile number"/>
            </div>
           	<div class="col-sm-4">
              <form:label path="faculty_telephone">
				 Telephone
			  </form:label>
              <form:input path="faculty_telephone" name="faculty_telephone" class="form-control required" placeholder="telephone number"/>
            </div>
          </div>
          <!-- Email -->
          <div class="form-group">
          	<div class="col-sm-5">
              <form:label path="faculty_email">
				 Email<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_email" name="faculty_email" class="form-control required" placeholder="email"/>
            </div>
          	<div class="col-sm-5">
              <form:label path="faculty_alt_email">
				 Alternate Email<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_alt_email" name="faculty_alt_email" class="form-control required" placeholder="alternate email"/>
            </div>
          </div>
		  <legend>Social Details</legend>
		  <!-- PAN & Aadhar -->
          <div class="form-group">
          	<div class="col-sm-5">
              <form:label path="faculty_pan">
				 PAN No.<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_pan" name="faculty_pan" class="form-control required" placeholder="pan number"/>
            </div>
          	<div class="col-sm-5">
              <form:label path="faculty_aadhar">
				 Aadhar No.<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_aadhar" name="faculty_aadhar" class="form-control required" placeholder="aadhar number"/>
            </div>
          </div>
		
		<legend>Bank Details</legend>
		  <!-- Bank Details -->
          <div class="form-group">
          	<div class="col-sm-5">
              <form:label path="faculty_bank_name">
				 Bank Name<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_bank_name" name="faculty_bank_name" class="form-control required" placeholder="bank name"/>
            </div>
          	<div class="col-sm-5">
              <form:label path="faculty_bank_branch">
				 Branch<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_bank_branch" name="faculty_bank_branch" class="form-control required" placeholder="bank branch"/>
            </div>
          </div>
          <div class="form-group">
          	<div class="col-sm-5">
              <form:label path="faculty_bank_account_no">
				 Account No.<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_bank_account_no" name="faculty_bank_account_no" class="form-control required" placeholder="account number"/>
            </div>
          	<div class="col-sm-5">
              <form:label path="faculty_bank_ifsc">
				 Bank IFSC Code<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_bank_ifsc" name="faculty_bank_ifsc" class="form-control required" placeholder="ifsc code"/>
            </div>
          </div>
          
          <legend>Education Details</legend>
          <!-- Degree -->
          <div class="form-group">
            <div class="col-sm-5">
              <form:label path="faculty_degree">
				 Degree<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_degree" name="faculty_degree" class="form-control required" placeholder="degree"/>
            </div>
          	<div class="col-sm-5">
              <form:label path="faculty_specialization">
				 Specialization<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_specialization" name="faculty_specialization" class="form-control required" placeholder="specialization"/>
            </div>
          </div>
          <!-- Masters -->
          <div class="form-group">
          	<div class="col-sm-5">
              <form:label path="faculty_masters">
				 Masters
			  </form:label>
              <form:input path="faculty_masters" name="faculty_masters" class="form-control" placeholder="masters"/>
            </div>
          	<div class="col-sm-5">
              <form:label path="faculty_masters_specialization">
				 Masters Specialization
			  </form:label>
              <form:input path="faculty_masters_specialization" name="faculty_masters_specialization" class="form-control" placeholder="masters specialization"/>
            </div>
          </div>
          <!-- PHD -->
          <div class="form-group">
          	<div class="col-sm-5">
              <form:label path="faculty_phd">
				 PHD
			  </form:label>
              <form:input path="faculty_phd" name="faculty_phd" class="form-control" placeholder="phd"/>
            </div>
          	<!-- PHD Specialization -->
            <div class="col-sm-5">
              <form:label path="faculty_phd_specialization">
				 PHD Specialization
			  </form:label>
              <form:input path="faculty_phd_specialization" name="faculty_phd_specialization" class="form-control" placeholder="phd specialization"/>
            </div>
          </div>
          
            <legend>Experience Details</legend>
          <div class="form-group">
          	<!-- Experience -->
            <div class="col-sm-5">
              <form:label path="faculty_experience">
				 Experience<span class="required">*</span>
			  </form:label>
              <form:input path="faculty_experience" name="faculty_experience" class="form-control required" placeholder="experience"/>
            </div>
          	<!-- Experience Type -->
            <div class="col-sm-5">
              <form:label path="faculty_exp_type">
				 Experience Type<span class="required">*</span>
			  </form:label>
              <form:select path="faculty_exp_type" class="form-control required" name="faculty_exp_type"  placeholder="experience type">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="None" label="None" />
						<form:option value="Teaching" label="Teaching" />
						<form:option value="Industrial" label="Industrial" />
			  </form:select>
            </div>
          </div>
		  <legend>Appointment Details</legend>
		  <div class="form-group">
		  <div class="col-sm-5">
		        <form:label path="faculty_appointment_type">
				 Appointment Type<span class="required">*</span>
			    </form:label>
	            <form:select  path="faculty_appointment_type" name="faculty_appointment_type" class="form-control required">
				<form:option value="NONE" label="--- Select ---" />
					<c:forEach var="list" items="${listAppt}">
				       		<form:option value="${list.appointment_id}">${list.appointment_name}</form:option> 
				   	</c:forEach>
				</form:select>
            </div>
            </div>
            <legend>Login Details</legend>
		  <div class="form-group">
		  <div class="col-sm-5">
		        <form:label path="faculty_appointment_type">
				 Username<span class="required">*</span>
			    </form:label>
	            <form:input path="user_name" name="user_name" class="form-control"/>
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
                <a class="btn btn-default" href="<c:url value="/faculties"/>">CANCEL</a>
              </div>
            </div>
          </div>
          
      </fieldset>
	</div>
</div>
</form:form>
</body>
</html>















