<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "edu.memphis.cardinal.*"%>
<%@ page import = "java.util.ArrayList"%>
<% String pageTitle = "Student Viewer"; %>  
<jsp:include page="header.jsp"><jsp:param name="pageTitle" value="<%= pageTitle %>" /></jsp:include>

<%if(request.getAttribute("flag") != null && request.getAttribute("flag").equals("true"))
	{
		%><script>jQuery(document).ready(function() { jQuery("#searchModal").modal("show"); });</script><%
	}
%>

<%!
	public String satisfies(Course r, String program)
	{
		String satisfaction = "";
		
		String number = r.getNumber();
		
		if(program.toLowerCase().equals("master"))
		{
			String mCore = "COMP 7012 COMP 7212 COMP 7612 COMP 7712";
			String mMethods = "COMP 7950";
			String mProjThesis = "COMP 7996 COMP 7980";
			String mAreaFA = "COMP 7295 COMP 7601 COMP 7713 COMP 7717 COMP 7719 COMP 7771 COMP 7820";
			String mAreaSNS = "COMP 7120 COMP 7125 COMP 7272 COMP 7274 COMP 7311 COMP 7313 COMP 7327 COMP 7900";
			String mAreaSLD = "COMP 7041 COMP 7081 COMP 7083 COMP 7085 COMP 7087 COMP 7115 COMP 7116 COMP 7117 COMP 7118 COMP 7130 COMP 7780";
			String mAreaIB = "COMP 7282 COMP 7290 COMP 7514 COMP 7515 COMP 7517 COMP 7711 COMP 7720 COMP 7740 COMP 7745 COMP 7750 COMP 7760 COMP 7770";
			String mMisc = "COMP 6901 COMP 6911 COMP 7901 COMP 8901 COMP 7980 COMP 7996";
			
			if(mCore.contains(number))
				satisfaction = "Core";
			else if(mMethods.contains(number))
				satisfaction = "Research Methods";
			else if(mProjThesis.contains(number))
				satisfaction = "Project/Thesis";
			else if(mAreaFA.contains(number))
				satisfaction = "Area: Foundations";
			else if(mAreaSNS.contains(number))
				satisfaction = "Area: Systems";
			else if(mAreaSLD.contains(number))
				satisfaction = "Area: Software";
			else if(mAreaIB.contains(number))
				satisfaction = "Area: Bio-Computing";
			else if(mMisc.contains(number))
				satisfaction = "Misc";
		}
		else if(program.toLowerCase().equals("phd"))
		{
			String pMethods = "COMP 7950"; 
			String pDissertation = "COMP 9000";
			String pCore = "COMP 7012 COMP 7212 COMP 7612 COMP 7712";
			
			if(pMethods.contains(number))
				satisfaction = "Research Methods";
			else if(pDissertation.contains(number))
				satisfaction = "Disseration";
			else if(pCore.contains(number))
				satisfaction = "Core";
		}
		else if(program.toLowerCase().equals("applied master"))
		{
			String aMerger = "COMP 7100 COMP 7105";
			String aCore = "COMP 7110 COMP 7970 COMP 6310 COMP 7517" +
							" COMP 7118 COMP 7970 MGMT 7030 MGMT 7135" +
							" MGMT 7140 MKTG 7910 ISDS 7311 COMP 7105" +
							" COMP 7150 COMP 7115 COMP 7517 COMP 7012" +
							" COMP 7081 COMP 7083 COMP 7970 MGMT 7135" +
							" MGMT 7170 MGMT 7421 COMP 7900";
			String aElective = "ACCT 7420 ACCT 7421 ACCT 7422 COMP 6081" +
								" COMP 6720 COMP 6730 COMP 7116 COMP 7282" +
								" COMP 7311 COMP 7313 COMP 7515 MIS 7610 MIS 7620" +
								" MIS 7640 MIS 7650 MIS 7655 MIS 7660 MIS 7665 MATH 7660";
			
			if(aMerger.contains(number))
				satisfaction = "Merger ";
			else if(aCore.contains(number))
				satisfaction = "Core";
			else if(aElective.contains(number))
				satisfaction = "Elective";
		}
	
		return satisfaction;	
	}
%>


<div class="span8 home-column-center">

<h1>Student Degree Requirements</h1>

<h3 class="text-info">Welcome<% if(session.getAttribute("user")!=null) out.print(" " + ((StudentModel)session.getAttribute("user")).getUsername()); %>!</h3>
	
<br>
<form action="list.do" method="POST">
<table class="table table-striped">

<tr>
	<td>
		Course Number
	</td>
	<td>
		Course Name
	</td>
	<td>
		Grade
	</td>
	<td>
		Prerequisites
	</td>
	<td>
		Department
	</td>
	<td>
		Satisfies
	</td>
</tr>
<% 	
	String program = ((StudentModel)session.getAttribute("user")).getProgram();

	ArrayList<Course> records;
	if(session.getAttribute("courses")!=null)
	{
		records = (ArrayList<Course>)session.getAttribute("courses");
		out.print("<tr></tr>");
	}
	else
		records = new ArrayList<Course>();
		
	String[] holder;
	for(int i = 0; i < records.size(); i++)
	{
		holder = records.get(i).getInfo();
		out.print("<tr>");
		for(int j = 0; j < holder.length; j++)
		{
			out.print("<td>");
			if(holder[j] != null && holder[j].length() > 0)
				out.print(holder[j]);
			else
				out.print("None");
			out.print("</td>");
		}
		
		out.print("<td>");
			out.print(satisfies(records.get(i), program));
		out.print("</td>");
		
		out.print("</tr>");
	}
	%>
</table>
<br />
<!-- 1. Course is added without error :: displayed via query and for loops
	 2. Course is malformed (grade or number) :: nothing added to DB, informative message added
	 		malformed: course number must be 9 characters starting with 4 alphabetic characters, a space, and then 4 numeric characters
	 					grade must be a letter followed by either nothing, a -, or a +
	 3. Course is not in DB :: check clipboard table (contains all user entered course information)-->
	 
	 <% if(request.getAttribute("message") != null)
		 out.println((String)(request.getAttribute("message")));%>

<a href="#searchModal" class="btn" data-toggle="modal">Search</a>

<div id="searchModal" class="modal hide fade" tabindex="-1">
  <div class="modal-header">
  <h3>Course Selector</h3>
  </div>
  <div class="modal-body">
  <table border="1">

<tr>
	Course Num: <input type="text" name = "user_course" value = ""><br>
	Department: <input type="text" name = "user_dept" value = ""><br>
	<td>
		Course Number
	</td>
	<td>
		Course Name
	</td>
	<td>
		Prerequisites
	</td>
	<td>
		Department
	</td>
	<td>
		Satisfies
	</td>
</tr>
<% 	
	String program1 = ((StudentModel)session.getAttribute("user")).getProgram();

	ArrayList<Course> records1;
	if(session.getAttribute("searched")!=null)
	{
		records1 = (ArrayList<Course>)session.getAttribute("searched");
		out.print("<tr></tr>");
	}
	else
		records1 = new ArrayList<Course>();
		
	String[] holder1;
	for(int i = 0; i < records1.size(); i++)
	{
		holder1 = records1.get(i).getBasicInfo();
		out.print("<tr>");
		for(int j = 0; j < holder1.length; j++)
		{
			out.print("<td>");
			if(holder1[j] != null && holder1[j].length() > 0)
				out.print(holder1[j]);
			else
				out.print("None");
			out.print("</td>");
		}
		
		out.print("<td>");
			out.print(satisfies(records1.get(i), program));
		out.print("</td>");
		
		out.print("</tr>");
	}
	%>
</table>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal">Close</button>
    <input type="submit" class="new-button new-button-submit" name="Search" value="Search">
    <input type="submit" class="new-button new-button-submit" name="Add" value="Add">
    <input type="submit" class="new-button new-button-submit" name="Remove" value="Remove">
	</div>
</div>
</form>

</div>



<jsp:include page="footer.jsp" />