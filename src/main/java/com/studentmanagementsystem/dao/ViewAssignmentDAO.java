package com.studentmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.studentmanagementsystem.bean.AssignmentBean;

public class ViewAssignmentDAO {

    public List<AssignmentBean> viewAssignment() {
        List<AssignmentBean> ls = new ArrayList<>(); // moved list inside method for clean instance
        try {
            Connection con = DBConnection.getCon();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM assignments");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                AssignmentBean ab = new AssignmentBean();
                ab.setTitle(rs.getString(2));
                ab.setDescription(rs.getString(3));
                ab.setSubject(rs.getString(4));
                ab.setAssigned_date(rs.getDate(5));
                ab.setDueDate(rs.getString(6));
                ab.setAssignmentFile(rs.getBytes(7));
                ls.add(ab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

     

        return ls;
    }
}
