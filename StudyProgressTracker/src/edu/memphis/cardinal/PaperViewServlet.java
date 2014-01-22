package edu.memphis.cardinal;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

@WebServlet("/ViewPapers")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "student", "faculty", "admin" }))
public class PaperViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PaperViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String studentId = request.getParameter("sid");
		String paperId = request.getParameter("pid");
		ArrayList<PublishedPaperModel> papersList = null;
		
		if(studentId.equals("0") && paperId.equals("0")) {
			StudentModel currentStudent = (StudentModel)session.getAttribute("user");
			papersList = new PublishedPaperDao().papersByStudentId(currentStudent.getId());
			request.setAttribute("list", papersList);
			
			if(papersList != null) {
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/PPapersList.jsp");
				view.forward(request, response);
			}
		} else if(studentId.equals("0") && !paperId.equals("0")) {
			PublishedPaperModel paper = new PublishedPaperDao().paperByPaperId(Integer.parseInt(paperId));
						
			if(paper != null) {
				RequestDispatcher view = request.getRequestDispatcher(paper.getFileName());
				view.forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		ServletContext servletContext = this.getServletConfig().getServletContext();
//		String studentId = request.getParameter("sid");
//		String paperId = request.getParameter("pid");
//		
//		PublishedPaperModel paper = new PublishedPaperDao().paperByPaperId(Integer.parseInt(paperId));
//		
//		String filePath = servletContext.getRealPath("/")+paper.getFileName();
//		
//		RequestDispatcher view = request.getRequestDispatcher(filePath);
//		view.forward(request, response);
	}

}
