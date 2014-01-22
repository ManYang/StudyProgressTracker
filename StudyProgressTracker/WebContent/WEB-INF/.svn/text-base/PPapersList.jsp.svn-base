<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="edu.memphis.cardinal.*"
    import="java.util.ArrayList" %>
<% String pageTitle = "Published Papers"; %> 
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<% ArrayList<PublishedPaperModel> list = (ArrayList<PublishedPaperModel>)request.getAttribute("list");
if(!(list.isEmpty())) { 
%>
	<table class="table table-striped">
		<caption>Stored Papers</caption>
		<thead>
			<tr>
				<th>Paper Title</th>
				<th>Date Stored</th>
			</tr>
		</thead>
		<tbody>
			<% for(PublishedPaperModel paper: list) { %>
				<tr>
					<td><a href="<% out.print("ViewPapers?sid=0&pid=" + paper.getPaperId()); %>"><% out.print(paper.getTitle()); %></a></td>
					<td><% out.print(paper.getStoredDate()); %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
<% } else { %>
	<h1>No papers have been uploaded!</h1>
	<% if(request.isUserInRole("student")) { %>
	<br>
		<h3 class="text-success">To upload a paper, <a href="StorePaper">click here</a>.</h3>
	<% } %>
<% } %>

<jsp:include page="footer.jsp" />