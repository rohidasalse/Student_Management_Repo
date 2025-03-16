package com.studentmanagementsystem.servlet;

import java.io.IOException;

import com.studentmanagementsystem.bean.RegistrationBean;
import com.studentmanagementsystem.dao.StudentLoginDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class StudentLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession hs=req.getSession();	
	RegistrationBean rb=StudentLoginDAO.recieve(req.getParameter("rollno"), req.getParameter("password"));
	if(rb==null) {
		req.setAttribute("msg","Username or Password something is wrong");
		req.getRequestDispatcher("studentLoginError.jsp").forward(req, resp);
		
	}
	else {
		hs.setAttribute("rb", rb);
		req.setAttribute("msg"," Login successful...");
		req.getRequestDispatcher("studentLoginSuccess.jsp").forward(req, resp);
		
	}
	
	
	}

}
