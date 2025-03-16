package com.studentmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudentDAO {
	public static int deleteStudent(String rollno) {
		
		int k=0;
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement("delete from student where STUDENTROLLNUMBER=?");
			pst.setString(1, rollno);
			 k = pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
