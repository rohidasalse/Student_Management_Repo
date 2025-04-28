<%@ page import="java.util.List" %>
<%@ page import="com.studentmanagementsystem.bean.AssignmentBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Assignments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">All Assignments</h2>

    <%
        List<AssignmentBean> assignmentList = (List<AssignmentBean>) request.getAttribute("assignmentList");

        if (assignmentList == null || assignmentList.isEmpty()) {
    %>
        <p class="text-center text-danger">No assignments available.</p>
    <%
        } else {
    %>
        <table class="table table-bordered table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>Title</th>
                    <th>Subject</th>
                    <th>Description</th>
                    <th>Due Date</th>
                    <th>Assigned Date</th>
                    <th>Download</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (AssignmentBean assignment : assignmentList) {
                %>
                <tr>
                    <td><%= assignment.getTitle() %></td>
                    <td><%= assignment.getSubject() %></td>
                    <td><%= assignment.getDescription() %></td>
                    <td><%= assignment.getDueDate() %></td>
                    <td><%= assignment.getAssigned_date() != null ? assignment.getAssigned_date().toString() : "Not Assigned" %></td>
                    <td>
                        <a href="downloadAssignment?title=<%= assignment.getTitle() %>" class="btn btn-sm btn-outline-primary">Download</a>
                    </td>
                    <td>
                        <a href="editAssignment?title=<%= assignment.getTitle() %>" class="btn btn-sm btn-warning me-2">Edit</a>
                        <a href="deleteAssignment?title=<%= assignment.getTitle() %>" class="btn btn-sm btn-danger" 
                           onclick="return confirm('Are you sure you want to delete this assignment?');">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <%
        }
    %>

    <div class="mt-4">
        <a href="addAssignment.html" class="btn btn-success">Add New Assignment</a>
         <a href="teacherLoginSuccess.jsp" class="btn btn-primary">Back to Dashboard</a>
    </div>
</div>

</body>
</html>
