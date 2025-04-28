package com.studentmanagementsystem.dao;



import com.studentmanagementsystem.bean.AssignmentBean;


import java.sql.*;

public class DownloadAssignmentDAO {

    public AssignmentBean getAssignmentByTitle(String title) {
        AssignmentBean ab = null;

        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM assignments WHERE title = ?")) {

            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ab = new AssignmentBean();
                ab.setTitle(rs.getString("title"));
                ab.setSubject(rs.getString("subject"));
                ab.setDescription(rs.getString("description"));
                ab.setDueDate(rs.getString("due_date"));
                ab.setAssigned_date(rs.getDate("assigned_date"));
                ab.setAssignmentFile(rs.getBytes("FILE_DATA")); // Replace with actual column name
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
System.out.println("ab"+ab);
        return ab;
    }
}
