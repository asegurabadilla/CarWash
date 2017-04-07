<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>	
<html> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
		<link rel="stylesheet" href="resources/css/bootstrap.min.css"> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script> 
		<script src="resources/js/bootstrap.min.js" ></script>
	    
	    <title>CarWash</title> 
	</head>

<body>
<h1>Users Maintance</h1>
	<div class= "container-fluid">
	<div class="row" >
		<a  class="btn btn-success"  href="<%= request.getContextPath() %>/Login/Add">Add</a>
	</div>
	<div class="row">
		<table class="table table-striped">
			<thead>
			<tr>
				<th>User</th>
				<th>Role</th>
			</tr>
			</thead>
			<tbody>
				<tr>
					<td>${user.getUserName()}</td>
						<c:forEach items="${user.getRole()}" var="role">
							<td>
								<p>Role Id:${role.getIdRol()}</p>
								<p>Role Name:${role.getRol()}</p>
								<p>Role Number:${role.getRoleNum()}</p>
							</td>
						</c:forEach>
					<td><a class="btn btn-danger" href="<%= request.getContextPath() %>/Login/Delete?usr=${usr.getUserId()}">Delete</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
<p>${message}</p>
</body>
</html>