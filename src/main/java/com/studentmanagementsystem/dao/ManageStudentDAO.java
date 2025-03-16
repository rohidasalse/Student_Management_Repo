package com.studentmanagementsystem.dao;

import java.util.*;
import java.util.List;
import java.sql.*;

import com.studentmanagementsystem.bean.RegistrationBean;

public class ManageStudentDAO {
	
	 public static List<RegistrationBean> getAllStudents() {
	        List<RegistrationBean> studentList = new ArrayList<>();
	        
	        try {
	            Connection conn = DBConnection.getCon();
	            String sql = "SELECT * FROM student";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	RegistrationBean student = new RegistrationBean();
	                student.setFullname(rs.getString(1));
	                student.setStudentrollnumber(rs.getString(2));
	                student.setEmail(rs.getString(3));
	                student.setGender(rs.getString(4));
	                student.setBranch(rs.getString(5));
	                student.setBloodgroup(rs.getString(6));
	                studentList.add(student);
	            }

	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return studentList;
	    }
}
