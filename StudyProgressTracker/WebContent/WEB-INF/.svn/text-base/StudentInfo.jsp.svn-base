<%@ page import="edu.memphis.cardinal.*" %>
<% String pageTitle = "Student Info Viewer"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

	<h1>Student Profile Search</h1>
	<form name="studentProfile" action="StudentInfoServlet.do" method="post">
		Student ID: <input type="text" name="studentID"><br><br>
		OR<br><br>
		Last Name: <input type="text" name="lastName"><br><br>
		First Name: <input type="text" name="firstName"><br><br>
		Major: <input type="radio" name="major" value="Computer Science">Computer Science
		<input type="radio" name="major" value="Computer Application">Computer Application
		<input type="radio" name="major" value="Bioinformatics">Bioinformatics
		<br><br>
		Program: <input type="radio" name="program" value="PhD">PhD
		<input type="radio" name="program" value="Master">Master
		<br><br>
		<input type="submit" name="search" value="search">
	</form>



<jsp:include page="footer.jsp" />