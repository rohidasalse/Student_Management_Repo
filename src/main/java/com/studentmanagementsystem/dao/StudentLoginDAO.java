package com.studentmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studentmanagementsystem.bean.RegistrationBean;

public class StudentLoginDAO {

	private static RegistrationBean rb = null;

	public static RegistrationBean recieve(String rollno, String password) {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con
					.prepareStatement("select * from student where  STUDENTROLLNUMBER=? and PASSWORD=?");
			pst.setString(1, rollno);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				rb = new RegistrationBean();
				rb.setFullname(rs.getString(1));
				rb.setStudentrollnumber(rs.getString(2));
				rb.setEmail(rs.getString(3));
				rb.setGender(rs.getString(4));
				rb.setBranch(rs.getString(5));
				rb.setBloodgroup(rs.getString(5));
				rb.setPassword(rs.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rb;
	}

}
