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

@WebServlet("/AdminHome")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"admin"}))
public class AdminHomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public AdminHomeServlet() {
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
				AdminModel admin = null;
				username = request.getRemoteUser();
				
				if (username != null) {
					admin = new AdminDao().adminByUsername(username);
				}
				
				session.setAttribute("user", admin);
				session.setAttribute("role", "admin");
				
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AdminHome.jsp");
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
				String currentPass = ((AdminModel)session.getAttribute("user")).getPassword();
				String oldPass = request.getParameter("old_pass");
				String newPass = request.getParameter("new_pass");
				if(!oldPass.equals(currentPass)) {
					request.setAttribute("error", "pass_check");
					RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AccountSettings.jsp");
					view.forward(request, response);
				} else if(new AdminDao().updatePassword(((AdminModel)session.getAttribute("user")).getId(), newPass)) {
					AdminModel newAdminObj = (AdminModel)session.getAttribute("user");
					newAdminObj.setPassword(newPass);
					session.setAttribute("user", newAdminObj);
					request.setAttribute("error", "success");
					RequestDispatcher view = request.getRequestDispatcher("WEB-INF/AccountSettings.jsp");
					view.forward(request, response);
				}
			}
		}
	}

}
