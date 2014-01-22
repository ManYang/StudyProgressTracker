package edu.memphis.cardinal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FacultyHome")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"faculty"}))
public class FacultyHomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public FacultyHomeServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session){
			if(!(request.getParameter("logout") == null)) {
				session.invalidate();
				response.sendRedirect("home");
			} else if(!(request.getParameter("type") == null)) {
				String type = request.getParameter("type");
				if(type.equals("account")) {
					RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AccountSettings.jsp");
					view.forward(request, response);
				}
			}
			else {
				String username = null;
				FacultyModel faculty = null;
				username = request.getRemoteUser();
				
				if (username != null) {
					faculty = new FacultyDao().facultyByUsername(username);
				}
				
				session.setAttribute("user", faculty);
				session.setAttribute("role", "faculty");
				
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/FacultyHome.jsp");
				view.forward(request, response);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.removeAttribute("error");
		HttpSession session = request.getSession();
		synchronized(session) {
			if(request.getParameter("old_pass") == null || request.getParameter("new_pass") == null || request.getParameter("old_pass").equals("") || request.getParameter("new_pass").equals("")) {
				request.setAttribute("error", "form_fill");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AccountSettings.jsp");
				view.forward(request, response);
			} else if(!(request.getParameter("old_pass") == null && request.getParameter("new_pass") == null)) {
				String currentPass = ((FacultyModel)session.getAttribute("user")).getPassword();
				String oldPass = request.getParameter("old_pass");
				String newPass = request.getParameter("new_pass");
				if(!oldPass.equals(currentPass)) {
					request.setAttribute("error", "pass_check");
					RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AccountSettings.jsp");
					view.forward(request, response);
				} else if(new FacultyDao().updatePassword(((FacultyModel)session.getAttribute("user")).getId(), newPass)) {
					FacultyModel newFacultyObj = (FacultyModel)session.getAttribute("user");
					newFacultyObj.setPassword(newPass);
					session.setAttribute("user", newFacultyObj);
					request.setAttribute("error", "success");
					RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AccountSettings.jsp");
					view.forward(request, response);
				}
			}
		}
	}

}
