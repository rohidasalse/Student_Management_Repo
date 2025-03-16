package com.studentmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studentmanagementsystem.bean.TeacherBean;

public class TeacherLoginDAO {
static private TeacherBean tb=null;
public static TeacherBean login(String teacherId,String password) {
	try {
		Connection con=DBConnection.getCon();
		PreparedStatement pst = con.prepareStatement("select * from teachers where TEACHER_ID=? and  PASSWORD=?");
		pst.setString(1, teacherId);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			tb=new TeacherBean();
			tb.setTeacher_id(rs.getString(1));
			tb.setName(rs.getString(2));
			tb.setEmail(rs.getString(3));
			tb.setPassword(rs.getString(4));
			tb.setSubject(rs.getString(5));
			tb.setDepartment(rs.getString(6));
	
			
		}
		
	
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return tb;
}

}
