package com.studentmanagementsystem.servlet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentmanagementsystem.dao.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        try (Connection conn = DBConnection.getCon()) {
            String sql = "SELECT  TITLE , FILE_DATA FROM assignments WHERE ASSIGNMENT_ID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                String fileName = result.getString(" TITLE ");
               
                InputStream fileData = result.getBinaryStream("FILE_DATA");
                
                response.setContentType("application/pdf");
                response.setHeader("Content-disposition", "attachment; filename=" + fileName+ ".pdf\"");
                
             ServletOutputStream out = response.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                
                while ((bytesRead = fileData.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                
                fileData.close();
                out.close();
            } else {
                response.getWriter().print("File not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.getWriter().print("Error: " + ex.getMessage());
        }
    }
}