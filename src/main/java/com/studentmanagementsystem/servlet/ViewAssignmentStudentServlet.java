package com.studentmanagementsystem.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.studentmanagementsystem.bean.AssignmentBean;
import com.studentmanagementsystem.dao.ViewAssignmentDAO;
import com.studentmanagementsystem.dao.ViewAssignmentStudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/viewAssignmentsstudent")
public class ViewAssignmentStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sc=req.getSession(false);
//		List<AssignmentBean> ls=new ArrayList<>();

		if(sc==null) {
			 req.setAttribute("msg","session expired...");
			 req.getRequestDispatcher("sessionExpired.jsp").forward(req, resp);
			
		}
		
		else {
		     List<AssignmentBean> assignmentList = new ViewAssignmentStudentDAO().viewAssignment();
		        
		      
		     req.setAttribute("assignmentList", assignmentList);
		     req.getRequestDispatcher("viewAssignmentsStudent.jsp").forward(req, resp);

		
			
		}
	}

}
