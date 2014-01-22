
<%@ page import="java.util.Vector" %>
<%@ page import="edu.memphis.cardinal.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String pageTitle = "Grade Edit"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<div class="row">
	
<div class="span8 home-column-center">

<%Vector<Grade> grade2 = (Vector<Grade>)request.getAttribute("grade");
	out.print("<h1>Welcome,&nbsp"+ grade2.get(0).getStudentName()+ "!</h1><h3 class=\"text-info\">Your student ID is:"+grade2.get(0).getStudentName()+"</h3>");
%>

<br>
<table class="table table-striped">
<tr><td><h4>Course ID</h4></td><td><h4>Course name</h4></td><td><h4>Grade</h4></td><td><h4>Edit Grade</h4></td>
</tr>


<form name="studentEditGrade"  method="post" action="cardinalServlet">
<%  
 	
	for(int i=0;i<grade2.size();i++)
 	{
		//String textName="text"+i;
		//out.print("<tr><td>"+grade2.get(i).getCourseID()+"</td><td>"+grade2.get(i).getCourseName()+"</td><td><input name='"+textName+"' type='text' value='"+grade2.get(i).getGrade()+"'></td>");
		String selectName="select"+i;
		out.print("<tr><td>"+grade2.get(i).getCourseID()+"</td><td>"+grade2.get(i).getCourseName()+"</td><td>"+grade2.get(i).getGrade()+"</td><td><select name='"+selectName+"'><option value='A+'>A+</option><option value='A'>A</option><option value='B+'>B+</option><option value='B'>B</option><option value='C+'>C+</option><option value='C'>C</option><option value='F'>F</option></select></td>");

 	}
 	%>
</table>
<input name="saveGrade" type="submit" value="Save" class="new-button new-button-submit">
<input name="back" type="submit" value="Back" class="new-button new-button-white">

</form>

</div>
</div>

<jsp:include page="footer.jsp" />