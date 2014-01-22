package edu.memphis.cardinal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.lang.Integer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentInfoServlet
 */
@WebServlet("/StudentInfoServlet.do")
public class StudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StudentInfo.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		if(!(request.getParameter("back") == null)) {
//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/StudentInfo.jsp");
//			view.forward(request, response);
//		}
		
		String studentID = request.getParameter("studentID");
		int istudentID = 0;
		if (studentID == null || studentID.equals("")) {
			studentID = "0";
		} else {
			istudentID = Integer.parseInt(studentID);
		}
		StudentInfo studentInfo = new StudentInfo(istudentID, 
			request.getParameter("lastName"), request.getParameter("firstName"), 
			request.getParameter("major"), request.getParameter("program"));
		
		StudentInfoDB db = new StudentInfoDB();
		Vector<StudentInfo> students = db.getStudentInfo(studentInfo);

		PrintWriter out = response.getWriter();
		String resultPage = "<!DOCTYPE html>\n";
		resultPage += "<html>\n";
		resultPage += "<body>\n";
		
		if (students.size() == 0) {
			resultPage += "<h1> No matching result! </h1>\n";
		} else {
			resultPage += "<h1> Student Profile </h1>\n";
			resultPage += "<table border=\"1\">\n";
			
			resultPage += "<tr>\n";
			resultPage += "<td> Student ID </td>\n";
			resultPage += "<td> Last Name </td>\n";
			resultPage += "<td> First Name </td>\n";
			resultPage += "<td> Major </td>\n";
			resultPage += "<td> Program </td>\n";
			resultPage += "<td> GPA </td>\n";
			resultPage += "<td> Department </td>\n";
			resultPage += "</tr>\n";
		
			for (int index = 0; index < students.size(); index = index + 1)
			{
				resultPage += "<tr>\n";
				resultPage += "<td> " + students.get(index).getID() + "</td>\n";
				resultPage += "<td> " + students.get(index).getLastName() + "</td>\n";
				resultPage += "<td> " + students.get(index).getFirstName() + "</td>\n";
				resultPage += "<td> " + students.get(index).getMajor() + "</td>\n";
				resultPage += "<td> " + students.get(index).getProgram() + "</td>\n";
				resultPage += "<td> " + students.get(index).getGPA() + "</td>\n";
				resultPage += "<td> " + students.get(index).getDepartment() + "</td>\n";
				resultPage += "</tr>\n";
			}
		
			resultPage += "</table>\n";
		}
		
		resultPage += "<br><br><a name = \"back\" href = \"StudentInfoServlet.do\"> Go Back </a>\n";
		resultPage += "</body>\n";
		resultPage += "</html>\n";
		out.println(resultPage);
	}
}
