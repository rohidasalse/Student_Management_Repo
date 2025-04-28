package com.studentmanagementsystem.servlet;

import java.io.IOException;

import com.studentmanagementsystem.bean.TeacherBean;
import com.studentmanagementsystem.dao.TeacherRegistrationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/teacherreg")
public class TeacherRegistrationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession hs=req.getSession(false);
	TeacherBean tb=new TeacherBean();
	System.out.println("teacher registration form");
//	tb.setTeacher_id(req.getParameter("teacherid"));
	tb.setName(req.getParameter("fullname"));
	tb.setEmail(req.getParameter("email"));
	tb.setPassword(req.getParameter("password"));
	tb.setSubject(req.getParameter("subject"));
	tb.setDepartment(req.getParameter("department"));
	int k=TeacherRegistrationDAO.register(tb);
	if(k>0) {
		req.setAttribute("msg", "Registration Successful...");
		req.getRequestDispatcher("teacherRegistrationSuccess.jsp").forward(req, resp);
	}
	else {
		req.setAttribute("msg", "Registration fail...");
		req.getRequestDispatcher("teacherRegistrationfail.jsp").forward(req, resp);
	}
	}

}
