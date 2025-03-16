package com.studentmanagementsystem.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagementsystem.bean.RegistrationBean;
import com.studentmanagementsystem.bean.TeacherBean;
import com.studentmanagementsystem.dao.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//
//import java.io.IOException;
//import java.util.List;
//
//import com.studentmanagementsystem.bean.RegistrationBean;
//import com.studentmanagementsystem.dao.ManageStudentDAO;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/manageStudents")
//
//public class ManageStudentsServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		if (session == null) {
//
//		} else {
//			List<RegistrationBean> studentList = ManageStudentDAO.getAllStudents();
//			session.setAttribute("students", studentList);
//			request.getRequestDispatcher("manageViewStudents.jsp").forward(request, response);
//
//		}
//
//	}
//
//}
@WebServlet("/manageStudents")
public class ManageStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve existing session
        HttpSession session = request.getSession(false);

        // Check if teacher session exists
        TeacherBean teacher = (TeacherBean) session.getAttribute("tb");
        if (teacher == null) {
            response.sendRedirect("teacherLogin.html");
            return;
        }
        
        	
        	
        	// Fetch student data from database
        	List<RegistrationBean> studentList = new ArrayList<>();
        	try {
        		Connection conn = DBConnection.getCon();
        		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student");
        		ResultSet rs = stmt.executeQuery();
        		
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
        		
        		// Store student list in session
        		session.setAttribute("students", studentList);
        		session.setAttribute("teacher", teacher);
        		
        		
        		// Forward to JSP page
        		request.getRequestDispatcher("manageViewStudents.jsp").forward(request, response);
        		
        	} 
        	catch (Exception e) {
        		e.printStackTrace();
        	}
        

    }
}

