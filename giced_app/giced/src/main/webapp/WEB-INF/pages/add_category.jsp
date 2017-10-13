<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Category</title>

<link href="<c:url value="/resources/core/css/bootstrap.min.css"/>" rel="stylesheet" />
    <script>
    function validateform(){  
		var category_id=document.CatForm.category_id.value;  
		var category_name=document.CatForm.category_name.value;  
		
		if (category_id==null || category_id==""){  
		  alert("Category Id can't be blank.");  
		  return false;  
		}
		if (category_name==null || category_name==""){  
			  alert("Category Name can't be blank.");  
			  return false;  
		}
	}  
    </script>
</head>
<body>

<c:url var="post_url"  value="/categories/add" />
<form:form action="${post_url}" modelAttribute="cat" method="post" 
class="form-horizontal" name="CatForm" onsubmit="return validateform()" >
<div class="row" >
	    		<div class="col-md-8 col-md-offset-1">
	      			<fieldset>
	      				<legend>Add New Category</legend>
				      	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="category_id">
				                    <spring:message text="Category Id"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="category_id" name="category_id" class="form-control required"/>
				            </div>
			          	</div>
			          	<div class="form-group">
				            <div class="col-sm-4">
				            	<form:label path="category_name">
				                    <spring:message text="Category"/><span class="required">*</span>
				                </form:label>
				              	<form:input path="category_name" name="category_name" class="form-control required"/>
				            </div>
			          	</div>
				      	<c:if test="${not empty errorMsg}">
    						<div class="alert alert-danger">
    							<c:out value="${errorMsg}"/>
    						</div>
    					</c:if>
				      	<div class="form-group">
				            <div class="col-sm-5 col-sm-offset-1">
				              <div class="pull-left">
				                <button type="submit" class="btn btn-primary">SAVE</button>
				                <a class="btn btn-default" href="<c:url value="/categories"/>">CANCEL</a>
				              </div>
				            </div>
			           </div>
	      			</fieldset>
				</div>
			</div>
</form:form>
</body>
</html>