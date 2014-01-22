<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String pageTitle = "Add Faculty"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<%
if(session.getAttribute("error")!=null){
	int isError = (Integer)(session.getAttribute("error"));	
		if(isError==1){
%>	
<div class="alert alert-error">Invaild Faculty Name</div>
<%} else if(isError==2){
%>
<div class="alert alert-success">Update Successfully</div>	
<%}else if(isError==3){%>
<div class="alert alert-error">Failed to update to database</div>

<% }}%>
	
<div class="form-horizontal" >
	<form method="post" >
  		<div class="control-group">
  		    <label class="control-label" for="faculty_name">Faculty Name</label>
  		    <div class="controls">
      			<input type="text" id="faculty_name" name="faculty_name" placeholder="Input faculty name">
    		</div>
		</div>

  		<div class="control-group">
  		    <label class="control-label" for="phone">Phone Number</label>
  		    <div class="controls">
      			<input type="text" id="phone" name="phone" placeholder="Input phone number">
    		</div>
		</div>

  		<div class="control-group">
  		    <label class="control-label" for="address">Address</label>
  		    <div class="controls">
      			<input type="text" id="address" name="address" placeholder="Input address">
    		</div>
		</div>	
  		<div class="control-group">
  		    <label class="control-label" for="faculty_password">Password</label>
  		    <div class="controls">
      			<input type="password" id="faculty_password" name="faculty_password" placeholder="Input faculty password">
    		</div>
		</div>
	
<!-- 
<table>
	<th>Basic Information</th>	
	<tr>Name:<input type="text"></tr>
	<tr>Title: <input type="text"></tr>
	<tr>Gender:<select name="facultyGender">
	<option value="Female">Female</option>
						<option value="Male">Male</option>
						<option value="N/A">N/A</option>
			</select></tr>
	<tr>E-mail:<input tyep="text"></tr>
	<tr>Address: <input type="text"></tr>
</table>
-->
  		<div class="control-group">
  		    <div class="controls">
				<input type="submit" value="Add" name="add_faculty" class="new-button new-button-submit">
    		</div>
		</div>	
	</form>
</div>

<jsp:include page="footer.jsp" />