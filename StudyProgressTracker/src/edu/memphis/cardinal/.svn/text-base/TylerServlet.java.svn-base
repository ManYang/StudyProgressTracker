package edu.memphis.cardinal;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TylerServlet
 */
@WebServlet("/list.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"student"}))
public class TylerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TylerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CourseDao c = new CourseDao();
		
		StudentModel user;
		
		synchronized(session)
		{
			if(session.getAttribute("user") != null)
				user = (StudentModel)session.getAttribute("user");
			else
				user = null;
			
			if(session.getAttribute("records") == null)
			{
				System.out.println(user.getUsername());
				
				ArrayList<Course> records = c.getCourses(user.getUsername());
				
				session.setAttribute("courses", records);
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/c_degree_requirements.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * NEEDS: session with user object which has user, an instance of StudentModel
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("flag", "false");

		
		HttpSession session = request.getSession();
		CourseDao c = new CourseDao();
		
		StudentModel user;
		String role;
		ArrayList<Course> records;
		synchronized(session)
		{
			if(session.getAttribute("user") != null)
				user = (StudentModel)session.getAttribute("user");
			else
				user = null;
			
			if(session.getAttribute("role") != null)
				role = (String)session.getAttribute("role");
			else
				role = null;
			
		}
		
		if(role.toLowerCase().equals("student"))
		{
			if(request.getParameter("Add") != null && request.getParameter("Add").equals("Add"))
			{
				System.out.println("add pressed");
				
				Course newCourse = new Course(request.getParameter("user_course"), "", "", "");
				
				int success = c.insertCourse(newCourse, user.getUsername());
				
				if(success != 1)
					request.setAttribute("message", "Course does not exist in catalog");
				else
					request.setAttribute("message", "Success!");
			}
			else if(request.getParameter("Search") != null && request.getParameter("Search").equals("Search"))
			{
				System.out.println("search pressed");
				request.setAttribute("flag", "true");
				
				synchronized(session)
				{
					session.setAttribute("searched", c.getCoursesLike(request.getParameter("user_course"), request.getParameter("user_dept")));
				}
			}
			else if(request.getParameter("Remove") != null && request.getParameter("Remove").equals("Remove"))
			{
				System.out.println("remove pressed");
				
				c.deleteCourse(request.getParameter("user_course"), user.getUsername());
			}
		}
		
		records = c.getCourses(user.getUsername());
		
		synchronized(session)
		{
			session.setAttribute("courses", records);
		}
		
		request.getRequestDispatcher("/WEB-INF/c_degree_requirements.jsp").forward(request, response);
	}

}
