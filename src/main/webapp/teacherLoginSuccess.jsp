<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.studentmanagementsystem.bean.*,java.util.*"%>
<%
String msg = (String) request.getAttribute("msg");
TeacherBean tb = (TeacherBean) session.getAttribute("tb");
String name = tb.getName();
String tid = tb.getTeacher_id();
String email = tb.getEmail();
String subject = tb.getSubject();
String department = tb.getDepartment();
HttpSession hs = request.getSession(false);
if (hs == null || name == null) {
	response.sendRedirect("teacherLogin.html");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Dashboard</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	margin: auto;
	padding: 20px;
	background: white;
	box-shadow: 0px 0px 10px gray;
	margin-top: 20px;
	border-radius: 10px;
}

.header {
	background: #007bff;
	color: white;
	padding: 15px;
	text-align: center;
	border-radius: 10px 10px 0 0;
}

.sidebar {
	width: 200px;
	float: left;
	background: #343a40;
	color: white;
	height: 100vh;
	padding: 20px;
	position: fixed;
}

.sidebar a {
	color: white;
	display: block;
	padding: 10px;
	text-decoration: none;
	list-style: none;
}

.section a {
	text-decoration: none;
	list-style: none;
}

.sidebar a:hover {
	background: #007bff;
}

.content {
	margin-left: 220px;
	padding: 20px;
}
</style>
</head>
<body>

	<div class="sidebar">
		<h2>Teacher Panel</h2>
		<a href="#">Dashboard</a> <a href="manageStudents">Manage Students</a> <a href="#">Assignments</a>
		<a href="#">Attendance</a> <a href="logoutTeacher.jsp">Logout</a>
	</div>

	<div class="content">
		<div class="container">
			<div class="header">
				<h2>
					Welcome,
					<%=name%>
					!
				</h2>
				<div>

					<div>

						<p>
							Department :
							<%=department%></p>
					</div>
					<div>
						<p>
							Subject :
							<%=subject%></p>
					</div>

				</div>
			</div>
			<div class="section">
				<h3>Actions</h3>
				<ul>
					<li><a href="manageStudents">View & Manage Students</a></li>
					<li><a href="#">Upload Assignments</a></li>
					<li><a href="#">Mark Attendance</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>