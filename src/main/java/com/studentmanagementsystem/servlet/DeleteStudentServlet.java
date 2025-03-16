package com.studentmanagementsystem.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import com.studentmanagementsystem.bean.RegistrationBean;
import com.studentmanagementsystem.dao.DeleteStudentDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   private static boolean remove=false,check=false;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rollno = request.getParameter("rollno");

        // Update session list
        HttpSession session = request.getSession(false);
        if(session==null) {
        	
        }
        else {
        	
        	ArrayList<RegistrationBean> students = (ArrayList<RegistrationBean>) session.getAttribute("students");
        	if (students != null) {
        		 remove = students.removeIf(student -> student.getStudentrollnumber().equals(rollno));
        	}
        	if(remove) {
        		int k = DeleteStudentDAO.deleteStudent(rollno);
        		if(k>0) {
        			check=true;
        		}
        	}
        	if(check) {
        		
        		session.setAttribute("students", students);
        		response.sendRedirect("manageStudents");
        	}
        }
    }
}