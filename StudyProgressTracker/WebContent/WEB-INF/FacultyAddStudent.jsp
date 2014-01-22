<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String pageTitle = "Faculty Add Students"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>
<div class="row">

<div class="span8 home-column-center">

<form method="post">
<h3 class="text-info">Student Name:<input type="text" name="student_name"></h3>
<h3 class="text-info">Password: <input type="text" name="password"></h3>
<h3 class="text-info">Program </h3><select name="program">
<option value="PhD" >Phd</option>
<option value="Master" >Master</option>
<option value="Applied Master">Applied Master</option>
</select></h1>
<input type="submit" value="Add" name="add_student" class="new-button new-button-submit" >
</form>

</div>
</div>
<jsp:include page="footer.jsp" />