<html>
<jsp:useBean id="emp" class="my.app.models.Employee"></jsp:useBean>
<jsp:useBean id="empdao" class="my.app.models.EmployeeDAO"></jsp:useBean>
<%
emp = empdao.getEmployee(request.getParameter("e"));
%>

<body>
	<h1>Edit Employee</h1>
	<form action="EmployeeHandler?u" method="POST">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="empid"
					value="<%=emp.getEmpid()%>" readonly /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"
					value="<%=emp.getFirstname()%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"
					value="<%=emp.getLastname()%>" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
