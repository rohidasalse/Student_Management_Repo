<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, com.studentmanagementsystem.bean.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Students</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<script>
    function confirmDelete(rollno) {
        if (confirm("Are you sure you want to delete this student?")) {
            window.location.href = "DeleteStudentServlet?rollno=" + rollno;
        }
    }
</script>

</head>
<body>

<div class="container mt-5">
    <h2 class="text-center">Student List</h2>

    <table class="table table-bordered table-striped mt-3">
        <thead class="table-dark">
            <tr>
                <th>Full Name</th>
                <th>Roll Number</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Branch</th>
                <th>Blood Group</th>
                <th>Manage</th>
            </tr>
        </thead>
        <tbody>
            <%
            ArrayList<RegistrationBean> students = (ArrayList<RegistrationBean>) session.getAttribute("students");
            if (students.size()!=0) {
                Iterator<RegistrationBean> iterator = students.iterator();
                while (iterator.hasNext()) {
                    RegistrationBean student = iterator.next();
            %>
                <tr>
                    <td><%= student.getFullname() %></td>
                    <td><%= student.getStudentrollnumber() %></td>
                    <td><%= student.getEmail() %></td>
                    <td><%= student.getGender() %></td>
                    <td><%= student.getBranch() %></td>
                    <td><%= student.getBloodgroup() %></td>
                    <td>
                        <a href="editStudent.jsp?rollno=<%= student.getStudentrollnumber() %>" class="btn btn-warning btn-sm">Edit</a>
                        <button class="btn btn-danger btn-sm" onclick="confirmDelete('<%= student.getStudentrollnumber() %>')">Delete</button>
                    </td>
                </tr>
            <%
                }
            } else {
            %>
                <tr>
                    <td colspan="7" class="text-center">No students found.</td>
                </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <a href="teacherLoginSuccess.jsp" class="btn btn-primary">Back to Dashboard</a>
</div>

</body>
</html>
