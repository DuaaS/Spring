<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Faculty Details</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
</head>
<body>


<form:form class="form-horizontal" >
<c:url var="user"  value="faculty" />
  <div class="row" >
    <div class="col-md-8 col-md-offset-1">
      <fieldset>
          <legend>Personal Details</legend>
          <!-- Faculty Id -->
          <div class="form-group">
            <div class="col-sm-4">
              <spring:message text="Faculty Id: "/>
			  <spring:message text="${faculty.faculty_id}"/>
            </div>
            <div class="col-sm-2">
            </div>
           </div>
          
          <!-- Designation & Abbreviation -->
          <div class="form-group">
          	<div class="col-sm-2">
              <spring:message text="Designation: "/>
			  <spring:message text="${designation}"/>
            </div>
            <div class="col-sm-2">
            </div>
            <div class="col-sm-2">
              <spring:message text="Abbreviation: "/>
			  <spring:message text="${faculty.faculty_abbreviation}"/>
            </div>
          </div>
          <!-- Full Name -->
          <div class="form-group">
          	<div class="col-sm-4">
              <spring:message text="First Name: "/>
			  <spring:message text="${faculty.faculty_firstname}"/>
            </div>
            <div class="col-sm-4">
              <spring:message text="Middle Name: "/>
			  <spring:message text="${faculty.faculty_middlename}"/>
            </div>
            <div class="col-sm-4">
              <spring:message text="Last Name: "/>
			  <spring:message text="${faculty.faculty_lastname}"/>
            </div>
          </div>
          <div class="form-group">
          	<!-- Date of Birth-->
            <div class="col-sm-4">
              <spring:message text="Date of Birth: "/>
			  <spring:message text="${dob}"/>
            </div>
            <!-- Age-->
            <div class="col-sm-4">
              <spring:message text="Age: "/>
			  <spring:message text="${faculty.faculty_age}"/>
            </div>
          </div>
          <!-- Gender-->             
          <div class="form-group">
          <div class="col-sm-4">
          		<spring:message text="Gender: "/>
			  	<spring:message text="${faculty.faculty_gender}"/>
	      </div>
          </div>
          <!-- Nationality-->
          <div class="form-group">
          <div class="col-sm-4">
          		<spring:message text="Nationality: "/>
			  	<spring:message text="${country}"/>
            </div>
          </div>
          <!-- Caste, Sub-Caste & Category -->
          <div class="form-group">
	          <div class="col-sm-4">
	            	<spring:message text="Caste: "/>
				  	<spring:message text="${caste}"/>
	            </div>
	          <div class="col-sm-4">
	            	<spring:message text="Sub-Caste: "/>
				  	<spring:message text="${subcaste}"/>
	            </div>
	          <div class="col-sm-4">
            	<spring:message text="Category: "/>
			  	<spring:message text="${category}"/>
            </div>
          </div>
          <!-- Marital Status-->
          <div class="form-group">
          <div class="col-sm-4">
            	<spring:message text="Marital Status: "/>
			  	<spring:message text="${faculty.faculty_marital_status}"/>
            </div>
          </div>
          
          <legend>Contact Details</legend>
          <!-- Address -->
          <div class="form-group">
           <div class="col-sm-10">
              <spring:message text="Building Name: "/>
			  <spring:message text="${faculty.faculty_building}"/>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-10">
              <spring:message text="Street Name: "/>
			  <spring:message text="${faculty.faculty_street}"/>
            </div>
          </div>
          <div class="form-group">
          	<div class="col-sm-4">
              <spring:message text="Area: "/>
			  <spring:message text="${faculty.faculty_area}"/>
            </div>
            <div class="col-sm-4">
              <spring:message text="Station: "/>
			  <spring:message text="${faculty.faculty_station}"/>
            </div>
            <div class="col-sm-2">
              <spring:message text="Pincode: "/>
			  <spring:message text="${faculty.faculty_pincode}"/>
            </div>
          </div>
          <div class="form-group">
          	<div class="col-sm-5">
              <spring:message text="City: "/>
              <spring:message text="${faculty.faculty_city}"/>
            </div>
            <div class="col-sm-5">
              <spring:message text="State: "/>
              <spring:message text="${faculty.faculty_state}"/>
            </div>
          </div>
          <!-- Contact Numbers -->
          <div class="form-group">
          	<div class="col-sm-4">
              <spring:message text="Mobile No.: "/>
			  <spring:message text="${faculty.faculty_mobile}"/>
            </div>
            <div class="col-sm-4">
              <spring:message text="Alternate Mobile No.: "/>
			  <spring:message text="${faculty.faculty_alt_mobile}"/>
            </div>
           	<div class="col-sm-4">
              <spring:message text="Telephone: "/>
			  <spring:message text="${faculty.faculty_telephone}"/>
            </div>
          </div>
          <!-- Email -->
          <div class="form-group">
          	<div class="col-sm-5">
              <spring:message text="Email: "/>
			  <spring:message text="${faculty.faculty_email}"/>
            </div>
          	<div class="col-sm-5">
              <spring:message text="Alternate Email: "/>
			  <spring:message text="${faculty.faculty_alt_email}"/>
            </div>
          </div>
		
		  <legend>Social Details</legend>
		  <!-- PAN & Aadhar -->
          <div class="form-group">
          	<div class="col-sm-5">
              <spring:message text="PAN No.: "/>
			  <spring:message text="${faculty.faculty_pan}"/>
            </div>
          	<div class="col-sm-5">
              <spring:message text="Aadhar No.: "/>
			  <spring:message text="${faculty.faculty_aadhar}"/>
            </div>
          </div>

		  <legend>Bank Details</legend>
		  <!-- Bank Details -->
          <div class="form-group">
          	<div class="col-sm-5">
              <spring:message text="Bank Name: "/>
			  <spring:message text="${faculty.faculty_bank_name}"/>
            </div>
          	<div class="col-sm-5">
              <spring:message text="Branch Name: "/>
			  <spring:message text="${faculty.faculty_bank_branch}"/>
            </div>
          </div>
          <div class="form-group">
          	<div class="col-sm-5">
              <spring:message text="Account No.: "/>
			  <spring:message text="${faculty.faculty_bank_account_no}"/>
            </div>
          	<div class="col-sm-5">
              <spring:message text="IFSC Code: "/>
			  <spring:message text="${faculty.faculty_bank_ifsc}"/>
            </div>
          </div>
         
         <legend>Education Details</legend>
          <!-- Degree -->
          <div class="form-group">
            <div class="col-sm-5">
              <spring:message text="Degree: "/>
			  <spring:message text="${faculty.faculty_degree}"/>
            </div>
          	<div class="col-sm-5">
              <spring:message text="Specialization: "/>
			  <spring:message text="${faculty.faculty_specialization}"/>
            </div>
          </div>
          <!-- Masters -->
          <div class="form-group">
          	<div class="col-sm-5">
              <spring:message text="Masters: "/>
			  <spring:message text="${faculty.faculty_masters}"/>
            </div>
          	<div class="col-sm-5">
              <spring:message text="Masters Specialization: "/>
			  <spring:message text="${faculty.faculty_masters_specialization}"/>
            </div>
          </div>
          <!-- PHD -->
          <div class="form-group">
          	<div class="col-sm-5">
              <spring:message text="PHD: "/>
			  <spring:message text="${faculty.faculty_phd}"/>
            </div>
          	<!-- PHD Specialization -->
            <div class="col-sm-5">
              <spring:message text="PHD Specialization: "/>
			  <spring:message text="${faculty.faculty_phd_specialization}"/>
            </div>
          </div>
		  <legend>Experience Details</legend>
          <div class="form-group">
          	<!-- Experience -->
            <div class="col-sm-5">
              <spring:message text="Experience: "/>
			  <spring:message text="${faculty.faculty_experience}"/>
            </div>
          	<!-- Experience Type -->
            <div class="col-sm-5">
              <spring:message text="Experience Type: "/>
			  <spring:message text="${faculty.faculty_exp_type}"/>
            </div>
          </div>
		  <legend>Appointment Details</legend>
		  <div class="form-group">
		  <div class="col-sm-5">
		        <spring:message text="Appointment Type: "/>
			    <spring:message text="${faculty.faculty_appointment_type}"/>
            </div>
            </div>
          <legend></legend>
				
		  <!-- Command -->
          <div class="form-group">
	          <c:if test="${not empty faculty_profile}">
	          	<div class="col-sm-5 col-sm-offset-1">
	              <div class="pull-left">
	                <a class="btn btn-default" href="<c:url value="/editFaculty/${faculty.faculty_id}/${user}"/>">EDIT</a>
	                <a class="btn btn-default" href="<c:url value="/faculty"/>">CANCEL</a>
	              </div>
	            </div>
	          </c:if>
          </div>
          <div class="form-group">
          <c:if test="${empty faculty_profile}">
            <div class="col-sm-5 col-sm-offset-1">
              <div class="pull-left">
                <a class="btn btn-default" href="<c:url value="/faculties"/>">CANCEL</a>
              </div>
            </div>
            </c:if>
          </div>
        </fieldset>
     
    </div><!-- /.col-lg-12 -->
</div><!-- /.row -->
	
</form:form>
</body>
</html>