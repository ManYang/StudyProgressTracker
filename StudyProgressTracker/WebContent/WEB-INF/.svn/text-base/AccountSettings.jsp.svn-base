<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% String pageTitle = "Account Settings"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<% String servletResponse = "";
if(!(request.getAttribute("error") == null)) {
   	servletResponse = (String)request.getAttribute("error");
}
if(servletResponse.equals("form_fill")) { %>
    <div class="alert alert-error">All form fields must be filled out.</div>
<% } else if(servletResponse.equals("pass_check")) { %>
	<div class="alert alert-error">The old password entered is invalid. Please try again.</div>
<% } else if(servletResponse.equals("success")) { %>
	<div class="alert alert-success">Password has been changed successfully.</div>
<% } %>

<h1>Account Settings</h1>
<div class="signuponepage signupcontent clearfix">
	<div class="clearfix">
		<div class="sign-up">
			<div class="signup-box">
				<form action="<% if(request.isUserInRole("student")) { out.print("StudentHome"); } 
					else if(request.isUserInRole("faculty")) { out.print("FacultyHome"); }
					else if(request.isUserInRole("admin")) { out.print("AdminHome"); } %>" method="POST">
					<div class="form-element">
						<label>
							<strong>Old Password</strong>
							<input type="password" name="old_pass" />
						</label>
					</div>
					<div class="form-element">
						<label>
							<strong>New Password</strong>
							<input type="password" name="new_pass" />
						</label>
					</div>				
					<div class="form-element submit-button">
						<input name="changePass" type="submit" value="Submit" class="new-button new-button-submit">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />