package edu.memphis.cardinal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"student", "faculty", "admin"}))
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public IndexServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String address = null;
		if(request.isUserInRole("student")) {
			address = "StudentHome";
		} else if(request.isUserInRole("faculty")) {
			address = "FacultyHome";
		} else if(request.isUserInRole("admin")) {
			address = "AdminHome";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(address);
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String address = null;
		if(request.isUserInRole("student")) {
			address = "WEB-INF/StudentHome.jsp";
		} else if(request.isUserInRole("faculty")) {
			address = "WEB-INF/FacultyHome.jsp";
		} else if(request.isUserInRole("admin")) {
			address = "WEB-INF/AdminHome.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(address);
		view.forward(request, response);
	}


}
