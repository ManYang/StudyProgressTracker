<% String currentRole = (String)session.getAttribute("role");
String currentPath = request.getServletPath(); %>
    
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<a class="brand" href="#">
					<% if(currentRole.equals("student")) { out.print("Student"); } 
						else if(currentRole.equals("faculty")) { out.print("Faculty"); } 
						else if(currentRole.equals("admin")) { out.print("Admin"); }
					%>
				</a>
				<% if(currentRole.equals("student")) { %>
				<ul class="nav">
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/StudentHome.jsp")) { %> class="active" <% } %>><a href="StudentHome">Student Home</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/c_degree_requirements.jsp")) { %> class="active" <% } %>><a href="list.do">Add Grades</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/student_gradeView.jsp")) { %> class="active" <% } %>><a href="cardinalServlet">View Grades</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/PlannedCourses.do")) { %> class="active" <% } %>><a href="PlannedCourses.do">Add Planned Courses</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/PPapersList.jsp") || currentPath.equalsIgnoreCase("/WEB-INF/PPapersUpload.jsp")) { %> class="dropdown active" <% } else { %> class="dropdown" <% } %>>
						<a class="dropdown-toggle" id="storePapersDrop" data-toggle="dropdown" data-target="#" href="#">Published Papers
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="storePapersDrop">
							<li><a href="ViewPapers?sid=0&pid=0">View All</a></li>
							<li><a href="StorePaper">Upload Document</a></li>
						</ul>
					</li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/AccountSettings.jsp")) { %> class="active" <% } %>><a href="StudentHome?type=account">Account Settings</a></li>
					
					<span class="logout-button">
						<a id="link-signin" class="new-button" href="StudentHome?logout=true">Log out</a>
					</span>
				</ul>
				<% } else if(currentRole.equals("faculty")) { %>
				<ul class="nav">
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/FacultyHome.jsp")) { %> class="active" <% } %>><a href="FacultyHome">Faculty Home</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/StudentInfo.jsp")) { %> class="active" <% } %>><a href="StudentInfoServlet.do">Student Profile</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/FacultyAddStudent.jsp")) { %> class="active" <% } %>><a href="FacultyAddStudentServlet.do">Add Students</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/faculty_viewGrade.jsp") || currentPath.equalsIgnoreCase("/WEB-INF/faculty_confirmGrade.jsp")) { %> class="dropdown active" <% } else { %> class="dropdown" <% } %>>
						<a class="dropdown-toggle" id="studentGradesDrop" data-toggle="dropdown" data-target="#" href="#">Student Grades
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="studentGradesDrop">
							<li><a href="cardinalServlet">View Grades</a></li>
							<li><a href="cardinalServlet">Confirm Grades</a></li>
						</ul>
					</li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/AccountSettings.jsp")) { %> class="active" <% } %>><a href="FacultyHome?type=account">Account Settings</a></li>
					
					<span class="logout-button">
						<a id="link-signin" class="new-button" href="FacultyHome?logout=true">Log out</a>
					</span>
				</ul>
				<% } else if(currentRole.equals("admin")) { %>
				<ul class="nav">
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/AdminHome.jsp")) { %> class="active" <% } %>><a href="AdminHome">Admin Home</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/AddFaculty.jsp")) { %> class="active" <% } %>><a href="AddFacultyServlet.do">Add Faculty</a></li>
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/DelFaculty.jsp")) { %> class="active" <% } %>><a href="DelFacultyServlet.do">Remove Faculty</a></li>					
					<li <% if(currentPath.equalsIgnoreCase("/WEB-INF/AccountSettings.jsp")) { %> class="active" <% } %>><a href="AdminHome?type=account">Account Settings</a></li>					
					<span class="logout-button">
						<a id="link-signin" class="new-button" href="AdminHome?logout=true">Log out</a>
					</span>
				</ul>
				<% } %>
			</div>
		</div>