<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
<title>GICED</title>

<%-- <jsp:include page="header.jsp" /> --%>
<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel=stylesheet type="text/css" />

	<style>
            body {
                padding-top: 50px;
            }
            .navbar-template {
                padding: 40px 15px;
            }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</head>

<nav class="navbar navbar-inverse">
	 <div class="container-fluid">
	 	<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		    </button>
      		<a class="navbar-brand" href="#">GICED</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
            	<li><a href="<c:url value="/users"/>">Users</a></li>
                <li><a href="<c:url value="/roles"/>">Role</a></li>
                <li class="dropdown">
                	<!-- <div class="dropdown"> -->
	  					<a href="<c:url value="#"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Faculty Details<span class="caret"></span></a>
		  				<ul class="dropdown-menu" role="menu">
		    				<li><a href="<c:url value="/appointments"/>">Appointment</a></li>
		    				<li><a href="<c:url value="/castes"/>">Caste</a></li>
		    				<li><a href="<c:url value="/categories"/>">Category</a></li>
		    				<li><a href="<c:url value="/designations"/>">Designation</a></li>
		    				<li><a href="<c:url value="/faculties"/>">Faculty</a></li>
		    				<li><a href="<c:url value="/subcastes"/>">Sub-Caste</a></li>
	  					</ul>
					<!-- </div> -->
              	</li>
              	
              	<li class="dropdown">
                	<!-- <div class="dropdown"> -->
	  					<a href="<c:url value="#"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Course Details<span class="caret"></span></a>
		  				<ul class="dropdown-menu" role="menu">
		  					<li><a href="<c:url value="/courses"/>">Course</a></li>
		    				<li><a href="<c:url value="/durations"/>">Duration</a></li>
		    				<li><a href="<c:url value="/subjects"/>">Subject</a></li>
		    				<li><a href="<c:url value="/titles"/>">Title</a></li>
	  					</ul>
					<!-- </div> -->
              	</li>
              	<li><a href="<c:url value="/assignments"/>">Assignment</a></li>
              	<li><a href="<c:url value="/attendances"/>">Attendance</a></li>
				<li><a href="<c:url value="/get_report_page"/>">Reports</a></li>
              	<li><a href="<c:url value="/change_password"/>">Change Password</a></li>
              	<li><a href="<c:url value="/logout" />">Sign Out</a></li>
              	<%-- <li><a href="${pageContext.request.contextPath}/logout">Sign Out</a></li> --%>
       		</ul>
       		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       	</div>               
	</div> 
</nav>


</body>

