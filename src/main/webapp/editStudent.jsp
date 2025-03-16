<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*, com.studentmanagementsystem.bean.*"%>

<%
String rollNo = request.getParameter("rollno");
RegistrationBean student = null;

try {
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "rohidas", "1234");
    PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE studentrollnumber = ?");
    ps.setString(1, rollNo);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        student = new RegistrationBean();
        student.setFullname(rs.getString(1));
        student.setStudentrollnumber(rs.getString(2));
        student.setEmail(rs.getString(3));
        student.setGender(rs.getString(4));
        student.setBranch(rs.getString(5));
        student.setBloodgroup(rs.getString(6));
    }
    con.close();
} catch (Exception e) {
    e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center">Edit Student</h2>
    
    <form action="EditStudentServlet" method="POST">
        <input type="hidden" name="rollno" value="<%= rollNo %>">
        
        <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text" class="form-control" name="fullname" value="<%= student.getFullname() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" value="<%= student.getEmail() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Gender</label>
            <select class="form-select" name="gender" required>
                <option value="Male" <%= student.getGender().equals("Male") ? "selected" : "" %>>Male</option>
                <option value="Female" <%= student.getGender().equals("Female") ? "selected" : "" %>>Female</option>
                <option value="Other" <%= student.getGender().equals("Other") ? "selected" : "" %>>Other</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Branch</label>
            <select class="form-select" name="branch" required>
                <option value="CSE" <%= student.getBranch().equals("CSE") ? "selected" : "" %>>CSE</option>
                <option value="Electrical" <%= student.getBranch().equals("Electrical") ? "selected" : "" %>>Electrical</option>
                <option value="Mechanical" <%= student.getBranch().equals("Mechanical") ? "selected" : "" %>>Mechanical</option>
                <option value="Civil" <%= student.getBranch().equals("Civil") ? "selected" : "" %>>Civil</option>
                <option value="Electronics" <%= student.getBranch().equals("Electronics") ? "selected" : "" %>>Electronics</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Blood Group</label>
            <input type="text" class="form-control" name="bloodgroup" value="<%= student.getBloodgroup() %>" required>
        </div>

        <button type="submit" class="btn btn-success">Update</button>
        <a href="manageViewStudents.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>

</body>
</html>
