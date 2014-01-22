package edu.memphis.cardinal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PlannedCoursesServlet
 */
@WebServlet("/PlannedCourses.do")
public class PlannedCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlannedCoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		StudentModel student = (StudentModel)session.getAttribute("user");
		int studentId = student.getId();
		String studentID = String.valueOf(studentId);
		
		//String studentID = request.getParameter("studentID");
		
		CourseInfoDB courseInfoDB = new CourseInfoDB();
		Vector<CourseInfo> courses = courseInfoDB.getCourseInfo();
		PlannedCoursesDB plannedCoursesDB = new PlannedCoursesDB();
		
		for (int index = 0; index < courses.size(); index = index + 1)
		{
			String courseNum = courses.get(index).getCourseNum();
			String selectCourseNum = request.getParameter("select" + courseNum);
			String deleteCourseNum = request.getParameter("delete" + courseNum);
			if (selectCourseNum != null && selectCourseNum.equals(courseNum))
			{
				plannedCoursesDB.addPlannedCourses(new PlannedCourses(studentID, courseNum));
			}
			if (deleteCourseNum != null && deleteCourseNum.equals(courseNum))
			{
				plannedCoursesDB.deletePlannedCourses(new PlannedCourses(studentID, courseNum));
			}
		}
		
		PrintWriter out = response.getWriter();
		
		  
		
		String resultPage = "<% String pageTitle = \"Planned Course\"; %>\n";
		resultPage += "<jsp:include page=\"header.jsp\"><jsp:param name=\"pageTitle\" value=\"<%= pageTitle %>\" /></jsp:include>\n";
		resultPage += "<body>\n";
		resultPage += "<h1> Planned Courses </h1>\n";
		resultPage += "<form name=\"PlannedCourses\" action=\"PlannedCourses.do\" method=\"post\">\n";
		resultPage += "Student ID: <input type=\"text\" name=\"studentID\" value = \"" + studentID + "\"><br><br>\n";
		resultPage += "<table border=\"1\">\n";
		
		resultPage += "<tr>\n";
		resultPage += "<td> Course Number </td>\n";
		resultPage += "<td> Course Name </td>\n";
		resultPage += "<td> Select </td>\n";
		resultPage += "<td> Delete </td>\n";
		resultPage += "</tr>\n";
		
		for (int index = 0; index < courses.size(); index = index + 1)
		{
			resultPage += "<tr>\n";
			resultPage += "<td> " + courses.get(index).getCourseNum() + "</td>\n";
			resultPage += "<td> " + courses.get(index).getCourseName() + "</td>\n";
			if (plannedCoursesDB.searchPlannedCourses(new PlannedCourses(studentID, courses.get(index).getCourseNum())))
			{
				resultPage += "<td> chosen </td>\n";
				resultPage += "<td> <input type=\"checkbox\" name=\"delete" + courses.get(index).getCourseNum() + "\" value=\"" + courses.get(index).getCourseNum() + "\"> </td>\n";
			}
			else
			{
				resultPage += "<td> <input type=\"checkbox\" name=\"select" + courses.get(index).getCourseNum() + "\" value=\"" + courses.get(index).getCourseNum() + "\"> </td>\n";
				resultPage += "<td> unchosen </td>\n";
			}
			resultPage += "</tr>\n";
		}
		
		resultPage += "</table>\n";
		resultPage += "<br><br><input type=\"submit\" name=\"submit\" value=\"submit\">\n";
		resultPage += "</form>\n";
		resultPage += "<br><br><a name = \"back\" href = \"PlannedCourses.do\"> Go Back </a>\n";
		resultPage += "</body>\n";
		resultPage += "</html>\n";
		out.println(resultPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentID = request.getParameter("studentID");
		
		CourseInfoDB courseInfoDB = new CourseInfoDB();
		Vector<CourseInfo> courses = courseInfoDB.getCourseInfo();
		PlannedCoursesDB plannedCoursesDB = new PlannedCoursesDB();
		
		for (int index = 0; index < courses.size(); index = index + 1)
		{
			String courseNum = courses.get(index).getCourseNum();
			String selectCourseNum = request.getParameter("select" + courseNum);
			String deleteCourseNum = request.getParameter("delete" + courseNum);
			if (selectCourseNum != null && selectCourseNum.equals(courseNum))
			{
				plannedCoursesDB.addPlannedCourses(new PlannedCourses(studentID, courseNum));
			}
			if (deleteCourseNum != null && deleteCourseNum.equals(courseNum))
			{
				plannedCoursesDB.deletePlannedCourses(new PlannedCourses(studentID, courseNum));
			}
		}
		
		PrintWriter out = response.getWriter();
		String resultPage = "<!DOCTYPE html>\n";
		resultPage += "<html>\n";
		resultPage += "<body>\n";
		resultPage += "<h1> Planned Courses </h1>\n";
		resultPage += "<form name=\"PlannedCourses\" action=\"PlannedCourses.do\" method=\"post\">\n";
		resultPage += "Student ID: <input type=\"text\" name=\"studentID\" value = \"" + studentID + "\"><br><br>\n";
		resultPage += "<table border=\"1\">\n";
		
		resultPage += "<tr>\n";
		resultPage += "<td> Course Number </td>\n";
		resultPage += "<td> Course Name </td>\n";
		resultPage += "<td> Select </td>\n";
		resultPage += "<td> Delete </td>\n";
		resultPage += "</tr>\n";
		
		for (int index = 0; index < courses.size(); index = index + 1)
		{
			resultPage += "<tr>\n";
			resultPage += "<td> " + courses.get(index).getCourseNum() + "</td>\n";
			resultPage += "<td> " + courses.get(index).getCourseName() + "</td>\n";
			if (plannedCoursesDB.searchPlannedCourses(new PlannedCourses(studentID, courses.get(index).getCourseNum())))
			{
				resultPage += "<td> chosen </td>\n";
				resultPage += "<td> <input type=\"checkbox\" name=\"delete" + courses.get(index).getCourseNum() + "\" value=\"" + courses.get(index).getCourseNum() + "\"> </td>\n";
			}
			else
			{
				resultPage += "<td> <input type=\"checkbox\" name=\"select" + courses.get(index).getCourseNum() + "\" value=\"" + courses.get(index).getCourseNum() + "\"> </td>\n";
				resultPage += "<td> unchosen </td>\n";
			}
			resultPage += "</tr>\n";
		}
		
		resultPage += "</table>\n";
		resultPage += "<br><br><input type=\"submit\" name=\"submit\" value=\"submit\">\n";
		resultPage += "</form>\n";
		resultPage += "<br><br><a name = \"back\" href = \"PlannedCourses.do\"> Go Back </a>\n";
		resultPage += "</body>\n";
		resultPage += "</html>\n";
		out.println(resultPage);
	}

}
