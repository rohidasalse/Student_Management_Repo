<%@page import="com.studentmanagementsystem.dao.DBConnection"%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignment List</title>
</head>
<body>
    <h2>Submitted Assignments</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>TITLE</th>
            <th>Description</th>
            <th>SUBJECT</th>
            <th>Upload Date</th>
            <th>DUE_DATE</th>
            <th>Action</th>
        </tr>
        
        <%
            try (Connection conn = DBConnection.getCon()) {
                String sql = "SELECT ASSIGNMENT_ID, TITLE, DESCRIPTION,SUBJECT,ASSIGNED_DATE, DUE_DATE FROM assignments ORDER BY ASSIGNED_DATE DESC";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                
                while (result.next()) {
                    int id = result.getInt("ASSIGNMENT_ID");
                    String fileName = result.getString("TITLE");
                    String description = result.getString("DESCRIPTION");
                    String SUBJECT = result.getString("SUBJECT");
                    Timestamp uploadDate = result.getTimestamp("ASSIGNED_DATE");
                    String DUE_DATE = result.getString("DUE_DATE");
        %>
                    <tr>
                        <td><%= id %></td>
                        <td><%= fileName %></td>
                        <td><%= description %></td>
                        <td><%= SUBJECT %></td>
                        <td><%= uploadDate %></td>
                        <td><%= DUE_DATE %></td>
                        <td><a href="download?id=<%= id %>">Download</a></td>
                    </tr>
        <%
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        %>
    </table>
</body>
</html>