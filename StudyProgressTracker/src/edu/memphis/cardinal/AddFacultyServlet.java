package edu.memphis.cardinal;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddDelFacultyServlet
 */
@WebServlet("/AddFacultyServlet.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"admin"}))
public class AddFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFacultyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AddFaculty.jsp");
		view.forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//uses session to control pop-up notify
		HttpSession session = request.getSession();
		String faculty_name=request.getParameter("faculty_name");
		//to prevent it shown before user first open the page
		session.removeAttribute("error");
		request.setAttribute("faculty_name", faculty_name);
		FacultyDao facultyDao = new FacultyDao();
		if(faculty_name ==null || faculty_name.isEmpty()){
			//set "error" equals to 1, error can be any name, just needs same with jsp
			session.setAttribute("error", 1);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AddFaculty.jsp");
			view.forward(request, response);					
		}
		else{
			try {
				facultyDao.add(request.getParameter("faculty_name"), request.getParameter("faculty_password"),
						request.getParameter("phone"),request.getParameter("address"));
				session.setAttribute("error", 2);

			} 
			catch (SQLException e) {
				e.printStackTrace();
				session.setAttribute("error", 3);
				
			}			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AddFaculty.jsp");
			view.forward(request, response);			
		}

	}

}
