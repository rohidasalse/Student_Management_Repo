package com.studentmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studentmanagementsystem.bean.RegistrationBean;

public class RegistrationBAO {
public int register(RegistrationBean rb) {
	int k=0;
	try {
		
		Connection con=DBConnection.getCon();
		PreparedStatement pst = con.prepareStatement("insert into student values(?,'STU' || student_roll_seq.NEXTVAL,?,?,?,?,?)");
		pst.setString(1, rb.getFullname());
//		pst.setString(2, rb.getStudentrollnumber());
		pst.setString(2, rb.getEmail());
		pst.setString(3, rb.getGender());
		pst.setString(4, rb.getBranch());
		pst.setString(5, rb.getBloodgroup());
		pst.setString(6, rb.getPassword());
		k = pst.executeUpdate();
//		ResultSet executeQuery = pst.executeQuery();
	}
	catch(Exception e) {
		System.out.println("connection fail");
//		e.printStackTrace();
		
	}
	return k;
}
}
