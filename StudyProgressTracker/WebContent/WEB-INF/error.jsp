<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String fUsername = request.getParameter("j_username");
    session.setAttribute("loginError", 1);
    session.setAttribute("formUsername", fUsername);
    RequestDispatcher view = request.getRequestDispatcher("login.jsp");
	view.forward(request, response); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>

<h1 class="text-error">Login Error!</h1>

<h3 class="text-error">Bad username and/or password.</h3>

</body>
</html>
