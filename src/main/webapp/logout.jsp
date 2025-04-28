<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>

<%
HttpSession hs = request.getSession(false);

	
	hs.setAttribute("tb", null);
	hs.invalidate();
	hs.removeAttribute("tb");

response.sendRedirect("index.html");
%>
