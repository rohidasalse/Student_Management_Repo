package com.studentmanagementsystem.servlet;

import java.io.IOException;

import com.studentmanagementsystem.bean.RegistrationBean;
import com.studentmanagementsystem.dao.RegistrationBAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/registration")
public class RegisterationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RegistrationBean rb=new RegistrationBean();
		rb.setFullname(req.getParameter("fullname"));
		rb.setStudentrollnumber(req.getParameter("studentrollnumber"));
		rb.setEmail(req.getParameter("email"));
		rb.setGender(req.getParameter("gender"));
		rb.setBranch(req.getParameter("branch"));
		rb.setBloodgroup(req.getParameter("bloodgroup"));
		rb.setPassword(req.getParameter("password"));
		int register = new RegistrationBAO().register(rb);
		if(register>0) {
			req.setAttribute("msg", "Registration Successful...");
			req.getRequestDispatcher("registrationsuccess.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg", "Registration fail...");
			req.getRequestDispatcher("registrationfail.jsp").forward(req, resp);
		}
	}

}
