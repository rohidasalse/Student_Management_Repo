package com.studentmanagementsystem.servlet;

import java.io.IOException;

import com.studentmanagementsystem.bean.TeacherBean;
import com.studentmanagementsystem.dao.TeacherLoginDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/teacherlogin")
public class TeacherLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		TeacherBean tb=	TeacherLoginDAO.login(req.getParameter("teacher_id"),req.getParameter("password"));
		

		 if(tb==null) {
			req.setAttribute("msg","Username or Password something is wrong");
			req.getRequestDispatcher("teacherLoginError.jsp").forward(req, resp);
		}
		else {
			System.out.println(hs);
			hs.setAttribute("tb", tb);
			req.setAttribute("msg"," Login successful...");
			req.getRequestDispatcher("teacherLoginSuccess.jsp").forward(req, resp);
		}
		
	}

}
