<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="edu.memphis.cardinal.*"
    import="java.util.ArrayList" %>
<% String pageTitle = "Upload Papers"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<% int servletResponse = 0;
    if(!(session.getAttribute("formError") == null)) {
    	servletResponse = (Integer)session.getAttribute("formError");
    } else if(!(session.getAttribute("success") == null)) {
    	servletResponse = (Integer)session.getAttribute("success");
    }
    if(servletResponse == 2) { %>
    <div class="alert alert-error">
  Please enter a title and select a file to upload.
  </div>
  <% } else if(servletResponse == 3) { %>
    <div class="alert alert-error">
  Please enter a title.
  </div>
  <% } else if(servletResponse == 4) { %>
    <div class="alert alert-error">
  Please select a file to upload.
  </div>
  <% } else if(servletResponse == 5) { %>
    <div class="alert alert-error">
  Invalid file type. Please select a .pdf, a .doc, or a .docx file to upload.
  </div>
  <% } else if(servletResponse == 6) { %>
    <div class="alert alert-success">
  Paper details have been submitted successfully.
  </div>
  <% } else if(servletResponse == 1) { %>
  	<div class="alert alert-success">
	Document submitted successfully.
	</div>
	<% } %>

<legend>Published Paper Upload</legend>
<div class="signuponepage signupcontent clearfix">


<div class="row">
<div class="span6" id="uploadBox">
<div class="sign-up">
<div class="signup-box">
<form action="StorePaper" method="POST" enctype="multipart/form-data">
<div class="form-element">
<label>
<strong>Title</strong>
<input type="text" name="title" />
</label>
</div>
<div class="form-element">
<label>
<strong>Select document</strong>
<input type="file" name="file" />
</label>
</div>

<div class="form-element submit-button">
<input name="submit" type="submit" value="Submit" class="new-button new-button-submit">
</div>
</form>
</div>
</div>
</div>

<div class="span6">
<% ArrayList<PublishedPaperModel> list = (ArrayList<PublishedPaperModel>)request.getAttribute("papers");
if(!(list.isEmpty())) { 
%>
	<table class="table table-striped">
		<caption>Previous Uploads</caption>
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
	<h3>No papers have been uploaded yet</h3>
<% } %>
</div>
</div>



</div>

<jsp:include page="footer.jsp" />