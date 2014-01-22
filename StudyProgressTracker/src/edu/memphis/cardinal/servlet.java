package edu.memphis.cardinal;


import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.memphis.cardinal.*;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/cardinalServlet")
//@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"student"}))
// Cannot use authentication on this servlet because it handles pages pages that can be viewed
// by only students and only faculty, but not both. They'll need to be put into separate servlets
public class servlet extends HttpServlet {
	public Vector<Grade> grade=null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		HttpSession session = request.getSession();
		String address = null;
		String role = (String)session.getAttribute("role");
		if(request.isUserInRole("student")){
		StudentModel student = (StudentModel)session.getAttribute("user");
		int studentID = student.getId();
		//System.out.println(studentID);
		Dao dao=new Dao();
		address="WEB-INF/student_gradeView.jsp";
		grade=dao.selectGrade(studentID);
		System.out.println(grade.get(0).getCourseID());
		} else if(request.isUserInRole("faculty")) {
			 address = "WEB-INF/faculty_viewGrade.jsp";
		}
		
		
		
		request.setAttribute("grade", grade);
		//request.setAttribute("a", a);
		RequestDispatcher dispatcher=request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("doPost");
		//HttpSession session = request.getSession();
		Dao dao=new Dao();
		String address="WEB-INF/student_gradeView.jsp";
		int studentID;
		String a=null;
		//grade=dao.selectGrade();
		
		
		
		
		
		
		
		
		HttpSession session = request.getSession();
		//String address = null;
		String role = (String)session.getAttribute("role");
		if(request.isUserInRole("student")){
		StudentModel student = (StudentModel)session.getAttribute("user");
		studentID = student.getId();
		//System.out.println(studentID);
		//Dao dao=new Dao();
		address="WEB-INF/student_gradeView.jsp";
		grade=dao.selectGrade(studentID);
		System.out.println(grade.get(0).getCourseID());
		} else if(request.isUserInRole("faculty")) {
			 address = "WEB-INF/faculty_viewGrade.jsp";
		}
		
//-----------------------------------------------------------------------------------------------				
//		if (request.getParameter("search")!=null)
//		{
//			studentID=Integer.parseInt(request.getParameter("studentID"));
//			grade=dao.selectGrade(studentID);
//			address="student_gradeView.jsp";
//		}
//---------------------------------------------------------------------------------------------		
		if(request.getParameter("editGrade")!=null)
		{
			address="WEB-INF/student_gradeEdit.jsp";
		}
//----------------------------------------------------------------------------------------------		
		if(request.getParameter("saveGrade")!=null)
		{
			for (int i=0;i<grade.size();i++)
			{
 				//String textName="text"+i;
 				//String g = (String)request.getParameter(textName);
 				//dao.editGrade(grade.get(i).getStudentID(),grade.get(i).getCourseID(), g);
				String selectName="select"+i;
				dao.editGrade(grade.get(i).getStudentID(),grade.get(i).getCourseID(), (String)request.getParameter(selectName));
			}
			grade=dao.selectGrade(grade.get(0).getStudentID());
			address="WEB-INF/student_gradeView.jsp";
		}
//-------------------------------------------------------------------------------------------------		
		if(request.getParameter("facultySearch")!=null)
		{
			if(request.getParameter("searchBy")!=null && request.getParameter("searchBy").equals("studentID"))
			//studentID=Integer.parseInt(request.getParameter("searchText"));
				grade=dao.selectGrade(Integer.parseInt(request.getParameter("searchText")));
			else if(request.getParameter("searchBy")!=null && request.getParameter("searchBy").equals("userName"))
				grade=dao.selectGradeByUserName((String)(request.getParameter("searchText")));
			address="WEB-INF/faculty_viewGrade.jsp";
			a="display";
		}
//--------------------------------------------------------------------------------------------------		
	
	if(request.getParameter("facultyConfirmGrade")!=null)
		{
			int s=0;
			for(int i=0;i<grade.size();i++)
			{
				String radioName="radio"+i;
				if(request.getParameter(radioName).equals("accept"))
					s=1;
				else
					s=0;
				dao.comfirmGrade(grade.get(i).getStudentID(),grade.get(i).getCourseID(), s);
				grade=dao.selectGrade(grade.get(0).getStudentID());
			}
			address="WEB-INF/faculty_confirmGrade.jsp";
			a="display";
		}
//-------------------------------------------------------------------------------------------------	

		if(request.getParameter("back")!=null)
		{
			address="WEB-INF/StudentHome.jsp";
		}

		if(request.getParameter("facultyBack")!=null)
		{
			address="WEB-INF/FacultyHome.jsp";
		}
//------------------------------------------------------------------------------------------------		
		request.setAttribute("grade", grade);
		request.setAttribute("a", a);
		RequestDispatcher dispatcher=request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
	}

}
