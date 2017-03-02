<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>CarWash</title> 
	</head>

	<body>
		<div align="center">
			<form id="form" method="post" action="<%= request.getContextPath() %>/Login">
				<div>
					<table>
						<tr><td>User</td><td><input type="text"  id="user" name="user" required placeholder="xxxx@domain.com"  value=""/></td></tr>
						<tr><td>Password</td><td><input type="password"  id="pass" name="pass" required value="" /></td></tr>
				    </table>
				    <input type="submit" value="Submit"/>
				</div>
				<div>
					<p>forgot your password? <a href="<%= request.getContextPath() %>/Login/Change">click here</a></p>
				</div>
			</form>
			
			<p>${message}</p>
		</div>
	</body>
</html>
