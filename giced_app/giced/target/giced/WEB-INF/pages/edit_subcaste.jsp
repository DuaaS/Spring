<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Sub-Caste</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
    <script>
    function validateform(){  
		var subcaste_name=document.SubCasteForm.subcaste_name.value;  
		var caste_id=document.SubCasteForm.caste_id.value;  
		  
		
		if (subcaste_name==null || subcaste_name==""){  
			  alert("Sub-Caste Name can't be blank.");  
			  return false;  
		}
		
		if (caste_id==null || caste_id=="" || caste_id=="NONE"){  
			  alert("Please select a Caste.");  
			  return false;  
		}
		  
	}  
    </script>
</head>
<body>

<c:url var="post_url"  value="/subcastes/edit" />
<form:form action="${post_url}" modelAttribute="subcaste" method="post" 
class="form-horizontal" name="SubCasteForm" onsubmit="return validateform()" >
   <div class="row" >
<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Edit Sub-Caste</legend>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="subcaste_id">
				                    <spring:message text="Sub-Caste Id"/>
				                </form:label>
				              	<form:input path="subcaste_id" name="subcaste_id" class="form-control" readonly="true"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="subcaste_name">
				                    <spring:message text="Sub-Caste"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="subcaste_name" name="subcaste_name" class="form-control required"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="caste_id">
				                    <spring:message text="Caste"/><span class="required">*</span>
				                </form:label>
				              	<form:select  path="caste_id" name="caste_id" class="form-control required">
									<form:option value="NONE" label="--- Select ---" />
										<c:forEach var="list" items="${listCaste}">
									       <form:option value="${list.caste_id}">${list.caste_name}</form:option> 
									   </c:forEach>
									</form:select>
				            </div>
			          	</div>
				      	<c:if test="${not empty errorMsg}">
    							<spring:message text="${errorMsg}"/>
    						</c:if>
				      	<div class="form-group">
				            <div class="col-sm-5 col-sm-offset-1">
				              <div class="pull-left">
				                <button type="submit" class="btn btn-primary">SAVE</button>
				                <a class="btn btn-default" href="<c:url value="/subcastes"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>