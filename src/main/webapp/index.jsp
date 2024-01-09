<html>
<body>
	<h1>Employee Registration</h1>
	<%
	if (request.getParameter("s") != null) {
		int s = Integer.parseInt(request.getParameter("s"));
		String message = "";
		switch (s) {
		case 0:
			message = "<span style='color:red'>Error occurred. Please try again.</span>";
			break;
		case 1:
			message = "<span style='color:green'>Successfully saved.</span>";
			break;
		}
		out.println("<h4>" + message + "</h4>");
	}
	%>
	<form action="EmployeeHandler?n" method="POST">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="empid" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
