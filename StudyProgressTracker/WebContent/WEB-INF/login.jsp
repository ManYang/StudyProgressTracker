<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% int isLoginError = 0;
    String formUsername = null;
    if(!(session.getAttribute("loginError") == null)) {
    	isLoginError = 1;
    	formUsername = (String)session.getAttribute("formUsername");
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CS Grade Tracker - Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<% out.print("Bootstrap/css/bootstrap.css"); %>"/>
</head>
<body>
<div class="main content">
	<div class="login-box">
	<% if(isLoginError == 1) { %>
	<div class="alert alert-error" id="errormsg_1">
 		Invalid username or password. Please try again
 	</div>
 	<% } %>
		<div class="login-content-box">
<form id="loginform" action="j_security_check" method="post">
<div class="username-div">
  <label for="Username"><strong>Username</strong></label>
  <% if(isLoginError == 1 && formUsername != null) { %>
  <input type="text" name="j_username" id="Username" value="<% out.print(formUsername); %>" />
  <% } else { %>
  <input type="text" name="j_username" id="Username" value="" />
  <% } %>
</div>
<div class="password-div">
  <label for="Password"><strong>Password</strong></label>
  <input type="password" name="j_password" id="Password" />
</div>
<div id="button_holder">
<input type="submit" class="new-button new-button-submit" name="logIn" id="logIn" value="Log in">
</div>
</form>
</div>
</div>
</div>
</body>
</html>