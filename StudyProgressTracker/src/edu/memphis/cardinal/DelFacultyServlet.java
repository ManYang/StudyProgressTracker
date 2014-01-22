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
 * Servlet implementation class DelFaculty
 */
@WebServlet("/DelFacultyServlet.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"admin"}))

public class DelFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelFacultyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		session.removeAttribute("error");
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/DelFaculty.jsp");
		view.forward(request, response);			
	}		


	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String del_faculty=request.getParameter("del_faculty");
		//to prevent it shown before user first open the page
		session.removeAttribute("error");
		request.setAttribute("del_faculty", del_faculty);
		FacultyDao facultyDao = new FacultyDao();

		
		
		if(del_faculty ==null || del_faculty.isEmpty()){
			//set "error" equals to 1, error can be any name, just needs same with jsp
			session.setAttribute("error", 1);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/DelFaculty.jsp");
			view.forward(request, response);					
		}
		else{
			//to judge whether the input is integer
			try{
				int i=Integer.parseInt(request.getParameter("del_faculty"));
			}
			catch(NumberFormatException e){
				e.printStackTrace();
				session.setAttribute("error", 4);
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/DelFaculty.jsp");
				view.forward(request, response);
				// Added return statement to keep the other lines of code from executing when this error is reached
				return;
			}			
			try {
				if(facultyDao.facultyById(Integer.parseInt(request.getParameter("del_faculty")))!=null){
				facultyDao.delete(facultyDao.facultyById(Integer.parseInt(request.getParameter("del_faculty"))));
				session.setAttribute("error",2);
				}
				else if(facultyDao.facultyById(Integer.parseInt(request.getParameter("del_faculty")))==null)
				{
					session.setAttribute("error", 3);
					}
			} 
			catch (SQLException e) {
				e.printStackTrace();									
			}	
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/DelFaculty.jsp");
		view.forward(request, response);			
	}
	}
}
