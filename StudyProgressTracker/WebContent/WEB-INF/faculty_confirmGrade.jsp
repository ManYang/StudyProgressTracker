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
Search student by:<select name="searchBy">
<option value="studentID">Student ID</option>
<option value="userName">User Name</option>
</select>
<input name="searchText" type="text" >
<input name="facultySearch" type="submit" value="Search">

<table class="table table-striped">
<tr><td>Course ID</td><td>Course Name</td><td>Grade</td><td>Accept/Reject Grade</td>

<%
if ((String)(request.getAttribute("a"))!=null)
{
	Vector<Grade> grade = (Vector<Grade>)request.getAttribute("grade");
	out.print("<h3>Student Name:,"+ grade.get(0).getStudentName()+ "student ID is:"+grade.get(0).getStudentID()+"</h3>");

for(int i=0;i<grade.size();i++)
{
	String status=null;
	String radioName="radio"+i;
	if(grade.get(i).getStatus()==1)
		status="Accept";
	else if(grade.get(i).getStatus()==0)
		status="Reject";
	out.print("<tr><td>"+grade.get(i).getCourseID()+"</td><td>"+grade.get(i).getCourseName()+"</td><td>"+grade.get(i).getGrade()+"</td><td>"+status+"</td><tr>");
	
}
out.print("</table>	");
}
	%>

<input name="facultyBack" type="submit" value="Back">
</form>


</div>
</div>
<jsp:include page="footer.jsp" />