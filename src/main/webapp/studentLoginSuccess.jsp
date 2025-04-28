<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.studentmanagementsystem.bean.*,java.util.*"%>




	
<%
String msg = (String) request.getAttribute("msg");

RegistrationBean rb = (RegistrationBean) session.getAttribute("rb");
String name=rb.getFullname();
String sid=rb.getStudentrollnumber();
String  email=rb.getEmail();
String gender=rb.getGender();
String branch=rb.getBranch();
String bloodgroup=rb.getBloodgroup();

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
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
        .section {
            padding: 15px;
            margin-top: 10px;
            background: #f9f9f9;
            border-radius: 5px;
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
        <h2>Student Panel</h2>
        <a href="#">Dashboard</a>
        <a href="#">My Profile</a>
        <a href="#">Class Schedule</a>
        <a href="viewAssignmentsstudent">Assignments</a>
        <a href="#">Exams & Results</a>
        <a href="#">Attendance</a>
        <a href="#">Notices</a>
        <a href="logout.jsp">Logout</a>
    </div>

    <div class="content">
        <div class="container">
            <div class="header">
                <h2>Welcome, <%= name %>!</h2>
                <p>Student ID: <%= sid %> | Course: <%= branch %></p>
            </div>

            <div class="section">
                <h3>Announcements</h3>
                <ul>
                    <li>Exam schedule will be released soon.</li>
                    <li>Library will be closed on Sunday.</li>
                    <li>Sports event registration is open.</li>
                </ul>
            </div>
        </div>
    </div>



</body>
</html>