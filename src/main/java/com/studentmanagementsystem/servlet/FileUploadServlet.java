package com.studentmanagementsystem.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.studentmanagementsystem.dao.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class FileUploadServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	/*
    	 *  ab.setTitle(request.getParameter("title"));
			 ab.setDescription(request.getParameter("description"));
			 ab.setSubject(request.getParameter("subject"));
			 String parameter = request.getParameter("due_date");
				ab.setDueDate(parameter);
						Part filePart = request.getPart("file");
				InputStream fileContent = filePart.getInputStream();
				byte[] fileBytes = fileContent.readAllBytes();

				System.out.println("File Size: " + fileBytes.length); // Add this line to check size

//				ab.setAssignmentFile(fileBytes);

    	 */
        
        String title=request.getParameter("title");
        String description = request.getParameter("description");
        String subject=request.getParameter("subject");
        String  dueDate=request.getParameter("due_date");
        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String fileType = filePart.getContentType();
        InputStream fileContent = filePart.getInputStream();
        
        try (Connection conn =DBConnection.getCon()) {
            String sql = "INSERT INTO assignments (ASSIGNMENT_ID , TITLE, DESCRIPTION, SUBJECT, ASSIGNED_DATE, DUE_DATE, FILE_DATA)  VALUES (assignment_seq.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, subject);
            statement.setString(4, dueDate);
            
            statement.setBinaryStream(5, fileContent);

            /*
             * 	pst.setString(1, ab.getTitle());
			pst.setString(2, ab.getDescription());
			pst.setString(3, ab.getSubject());
			pst.setString(4,ab.getDueDate());		
			pst.setBytes(5, ab.getAssignmentFile());
             */
            
            int row = statement.executeUpdate();
            if (row > 0) {
                request.setAttribute("message", "File uploaded successfully!");
            }
        } catch (SQLException ex) {
            request.setAttribute("message", "ERROR: " + ex.getMessage());
            ex.printStackTrace();
            
        }
        
//        request.getRequestDispatcher("/result.jsp").forward(request, response);
        request.getRequestDispatcher("/teacherLoginSuccess.jsp").forward(request, response);
    }
}
