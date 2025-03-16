<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        response.sendRedirect("teacherlogin.html?msg=" + java.net.URLEncoder.encode(msg, "UTF-8"));
    } else {
        response.sendRedirect("teacherlogin.html");
    }
%>
</body>
</html>