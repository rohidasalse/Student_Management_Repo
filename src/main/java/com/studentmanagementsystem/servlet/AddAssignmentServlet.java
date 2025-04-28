package com.studentmanagementsystem.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.studentmanagementsystem.bean.AssignmentBean;
//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.studentmanagementsystem.dao.AddAssignmentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/AddAssignmentServlet")
public class AddAssignmentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		 if(hs==null) {
			 request.setAttribute("msg","session expired...");
			 request.getRequestDispatcher("sessionExpired.jsp").forward(request, response);
			 
		 }
		 else {
			 
			 
			 AssignmentBean ab = new AssignmentBean();
			 ab.setTitle(request.getParameter("title"));
			 ab.setDescription(request.getParameter("description"));
			 ab.setSubject(request.getParameter("subject"));
			 String parameter = request.getParameter("due_date");
				ab.setDueDate(parameter);

			 

				Part filePart = request.getPart("file");
				InputStream fileContent = filePart.getInputStream();
				byte[] fileBytes = fileContent.readAllBytes();

				System.out.println("File Size: " + fileBytes.length); // Add this line to check size

//				ab.setAssignmentFile(fileBytes);

			 ab.setAssignmentFile(fileBytes);
			 int k = new AddAssignmentDAO().addAssignment(ab);
			 if (k > 0) {
				    request.setAttribute("assignment_added_success", "Assignment added successfully...");
				    request.getRequestDispatcher("teacherLoginSuccess.jsp").forward(request, response); // ✅
				} else {
				    request.setAttribute("assignment_added_success", "Assignment failed.");
				    request.getRequestDispatcher("teacherLoginSuccess.jsp").forward(request, response);
				}

		 }

	}
}
