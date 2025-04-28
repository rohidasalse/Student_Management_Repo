package com.studentmanagementsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.studentmanagementsystem.bean.AssignmentBean;

public class AddAssignmentDAO {
	public int k;
	
	public int addAssignment(AssignmentBean ab) {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement(
				    "INSERT INTO assignments (ASSIGNMENT_ID , TITLE, DESCRIPTION, SUBJECT, ASSIGNED_DATE, DUE_DATE, FILE_DATA)  VALUES (assignment_seq.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)"
				);
			pst.setString(1, ab.getTitle());
			pst.setString(2, ab.getDescription());
			pst.setString(3, ab.getSubject());
			pst.setString(4,ab.getDueDate());		
			pst.setBytes(5, ab.getAssignmentFile());
		k = pst.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
