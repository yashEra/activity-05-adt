<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="my.app.models.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employee</title>
<jsp:useBean id="empdao" class="my.app.models.EmployeeDAO"></jsp:useBean>
</head>
<body>
	<h1>View Employee</h1>
	<%
	if (request.getParameter("s") != null) {
		int s = Integer.parseInt(request.getParameter("s"));
		String message = "";
		switch (s) {
		case 0:
			message = "<span style='color:red'>Error occurred. Please try again.</span>";
			break;
		case 1:
			message = "<span style='color:green'>Operation successful.</span>";
			break;
		}
		out.println("<h4>" + message + "</h4>");
	}
	%>
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Actions</th>
		</tr>
		<%
		for (Employee e : empdao.getEmployeeList()) {
		%>
		<tr>
			<td><%=e.getEmpid() %></td>
			<td><%=e.getFirstname() %></td>
			<td><%=e.getLastname() %></td>
			<td><a href="EmployeeHandler?u=<%=e.getEmpid() %>">Update</a> | <a href="EmployeeHandler?d=<%=e.getEmpid() %>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>