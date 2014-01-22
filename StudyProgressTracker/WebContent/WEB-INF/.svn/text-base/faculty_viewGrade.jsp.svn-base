<%@ page import="java.util.Vector" %>
<%@ page import="edu.memphis.cardinal.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String pageTitle = "Grade View for Faculty"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<div class="row">
	
<div class="span8 home-column-center">

<h1>Welcome!</h1>

<form name="facultyViewGrade"  method="post" action="cardinalServlet">
<h3 class="text-info">Search student by:</h3><select name="searchBy">
<option value="studentID">Student ID</option>
<option value="userName">User Name</option>
</select>
<input name="searchText" type="text" >
<input name="facultySearch" type="submit" value="Search">
<br>
<table border="1" cellpadding="10">
<tr><td>Course ID</td><td>Course Name</td><td>Grade</td><td>Accept/Reject Grade</td>

<%
if ((String)(request.getAttribute("a"))!=null)
{
	Vector<Grade> grade = (Vector<Grade>)request.getAttribute("grade");
	out.print("<h3 class=\"text-info\">Student Name:"+ grade.get(0).getStudentName()+ "<br>Student ID is:"+grade.get(0).getStudentID()+"</h3>");

for(int i=0;i<grade.size();i++)
{
	String radioName="radio"+i;
	
	out.print("<tr><td>"+grade.get(i).getCourseID()+"</td><td>"+grade.get(i).getCourseName()+"</td><td>"+grade.get(i).getGrade()+"</td><td><input type='radio' name='"+radioName+"' value='accept' />accept <input type='radio' name='"+radioName+"' value='reject' />reject</td><tr>");
	
}
out.print("</table>	<input name='facultyConfirmGrade' type='submit' value='Confirm'>");
}
	%>

<input name="facultyBack" type="submit" value="Back">
</form>

</div>
</div>

<jsp:include page="footer.jsp" />