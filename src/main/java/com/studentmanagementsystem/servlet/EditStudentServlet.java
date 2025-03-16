package com.studentmanagementsystem.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.studentmanagementsystem.bean.RegistrationBean;
import com.studentmanagementsystem.dao.ManageStudentDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rollNo = request.getParameter("rollno");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String branch = request.getParameter("branch");
        String bloodgroup = request.getParameter("bloodgroup");
HttpSession session = request.getSession(false);
if(session==null) {
	  response.sendRedirect("teacherLogin.html");
      return;
	
}
else {
	
	try {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "rohidas", "1234");
		PreparedStatement ps = con.prepareStatement("UPDATE student SET fullname=?, email=?, gender=?, branch=?, bloodgroup=? WHERE studentrollnumber=?");
		ps.setString(1, fullname);
		ps.setString(2, email);
		ps.setString(3, gender);
		ps.setString(4, branch);
		ps.setString(5, bloodgroup);
		ps.setString(6, rollNo);
		
		ps.executeUpdate();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}



	response.sendRedirect("manageStudents");
}
    }
}
