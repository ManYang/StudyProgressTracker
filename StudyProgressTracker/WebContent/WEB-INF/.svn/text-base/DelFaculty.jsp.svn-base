<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 %>
 <%@ page import="edu.memphis.cardinal.*" %>
 <%@ page import="java.sql.SQLException" %>
 <%@ page import= "java.util.ArrayList" %>
<% String pageTitle = "Remove Faculty"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<%
int isError=0;
if(session.getAttribute("error")!=null){
	isError = (Integer)(session.getAttribute("error"));
}
if(isError==1){%>
	
<div class="alert alert-error">Faculty ID is empty</div>
<%}
else if(isError==2){
%>
<div class="alert alert-success">Delete successfully</div>
<%} 
else if(isError==3){%>
<div class="alert alert-error">Invaild faculty ID</div>

<%} 
else if(isError==4){%>
<div class="alert alert-error">Input is not a number</div>
<%} %>
		<table class="table table-striped" style="width:500px">
			<tr>
				<th>Faculty ID</th>
				<th>User Name</th>
			</tr>
<%
try {
	AddDelFacultyDao delFaculty = new AddDelFacultyDao();	
	ArrayList<FacultyModel> all= delFaculty.showAll();
	for(int i=0; i<all.size(); i++){
 		out.print("<tr><td>"+all.get(i).getId()+"</td><td>"+all.get(i).getUsername()+"</td>");
	}
} 
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
		</table>

	<form method="post">
	<input type="text" value="Please input faculty ID" name="del_faculty">
	<input type="submit"  value="Delete" name="del_faculty" class="new-button new-button-submit">
	</form>
<jsp:include page="footer.jsp" />