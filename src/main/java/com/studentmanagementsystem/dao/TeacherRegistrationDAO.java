package com.studentmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.studentmanagementsystem.bean.TeacherBean;

public class TeacherRegistrationDAO {
	public static int register(TeacherBean tb) {
		int k=0;
		try {
			Connection con=DBConnection.getCon();	
			PreparedStatement pst = con.prepareStatement("insert into teachers values(?,?,?,?,?,?)");
			pst.setString(1, tb.getTeacher_id());
			pst.setString(2,tb.getName());
			pst.setString(3,tb.getEmail());
			pst.setString(4,tb.getPassword());
			pst.setString(5,tb.getSubject());
			pst.setString(6,tb.getDepartment());
	
			k = pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return k;
		
	}

}
