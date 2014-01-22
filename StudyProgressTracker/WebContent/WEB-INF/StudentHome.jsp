<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="edu.memphis.cardinal.*" %>
<% String pageTitle = "Student Home"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<h1>Hello <% out.print((String)session.getAttribute("role")); %>, <% StudentModel mstudent = (StudentModel)session.getAttribute("user"); out.print(mstudent.getUsername()); %>!</h1>

<jsp:include page="footer.jsp" />