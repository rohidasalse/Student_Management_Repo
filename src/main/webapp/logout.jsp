<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>

<%
HttpSession hs = request.getSession(false);

	hs.invalidate();


response.sendRedirect("index.html");
%>
