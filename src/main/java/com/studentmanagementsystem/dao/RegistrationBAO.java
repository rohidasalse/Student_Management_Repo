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
		PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
		pst.setString(1, rb.getFullname());
		pst.setString(2, rb.getStudentrollnumber());
		pst.setString(3, rb.getEmail());
		pst.setString(4, rb.getGender());
		pst.setString(5, rb.getBranch());
		pst.setString(6, rb.getBloodgroup());
		pst.setString(7, rb.getPassword());
		k = pst.executeUpdate();
//		ResultSet executeQuery = pst.executeQuery();
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return k;
}
}
