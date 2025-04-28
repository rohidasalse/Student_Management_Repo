package com.studentmanagementsystem.servlet;

import com.studentmanagementsystem.bean.AssignmentBean;
import com.studentmanagementsystem.dao.DownloadAssignmentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/downloadAssignment")
public class DownloadAssignmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        if (title == null || title.isEmpty()) {
            response.getWriter().println("Assignment title is missing");
            return;
        }

        AssignmentBean assignment = new DownloadAssignmentDAO().getAssignmentByTitle(title);

        if (assignment == null || assignment.getAssignmentFile() == null || assignment.getAssignmentFile().length == 0) {
            response.getWriter().println("Assignment not found or file is empty.");
            return;
        }

        byte[] fileData = assignment.getAssignmentFile();

        // Content type for PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + title + ".pdf\"");
        response.setContentLength(fileData.length);

        try (OutputStream out = response.getOutputStream()) {
            out.write(fileData);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
