
<%@ page import="java.util.Vector" %>
<%@ page import="edu.memphis.cardinal.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String pageTitle = "Grade View"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<div class="row">

<div class="span8 home-column-center">

<%Vector<Grade> grade1 = (Vector<Grade>)request.getAttribute("grade");
out.print("<h1>Welcome,&nbsp"+ grade1.get(0).getStudentName()+ "!</h1><h3 class=\"text-info\">Your student ID is:"+grade1.get(0).getStudentID()+"</h3>");
%>

<br>
<table class="table table-striped">
<tr><td><h3>Course ID</h3></td><td><h3>Course name</h3></td><td><h3>Grade</h3></td>
</tr>
<%  
 	for(int i=0;i<grade1.size();i++)
 	{
 		out.print("<tr><td>"+grade1.get(i).getCourseID()+"</td><td>"+grade1.get(i).getCourseName()+"</td><td>"+grade1.get(i).getGrade()+"</td>");
 		
 	}
 	%>
</table>

<form name="studentViewGrade"  method="post" action="cardinalServlet">

<input name="editGrade" type="submit" value="Edit Grade" class="new-button new-button-submit">
<input name="back" type="submit" value="Back" class="new-button new-button-white">

</form>

</div>
</div>

<jsp:include page="footer.jsp" />