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
 * Servlet implementation class FacultyAddStudentServlet
 */
@WebServlet("/FacultyAddStudentServlet.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"faculty"}))
public class FacultyAddStudentServlet extends HttpServlet {
	FacultyAddStudentDao dao=new FacultyAddStudentDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyAddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/FacultyAddStudent.jsp");
		view.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		String add_student=request.getParameter("add_student");
		request.setAttribute("add_student",add_student );

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/FacultyAddStudent.jsp");
		view.forward(request, response);
		if(add_student !=null){
			String student_name=request.getParameter("student_name");
			String password =request.getParameter("password");
			String program =request.getParameter("program");
			try {
				dao.update(student_name,password,program);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
