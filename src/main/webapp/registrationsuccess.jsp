<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    .fade-out {
        opacity: 1;
        transition: opacity 1s ease-out;
    }
    .hidden {
        opacity: 0;
        display: none;
    }
</style>
</head>
<body>

<%
String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
    <div id="notification" class="alert alert-success text-center fade-out" role="alert">
        <%= msg %>
    </div>
<%
}
%>
<%@include file="studentLogin.html"%>



<script>
    // Auto-hide alert after 5 seconds
    setTimeout(function() {
        let notification = document.getElementById("notification");
        if (notification) {
            notification.classList.add("hidden");
        }
    }, 5000);
</script>

</body>
</html>
