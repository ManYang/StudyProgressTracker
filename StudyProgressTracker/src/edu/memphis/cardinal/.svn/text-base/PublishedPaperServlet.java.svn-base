package edu.memphis.cardinal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

@WebServlet("/StorePaper")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "student" }))
public class PublishedPaperServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PublishedPaperServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			session.removeAttribute("formError");
			session.removeAttribute("success");
			
			int studentId = ((StudentModel)session.getAttribute("user")).getId();
			ArrayList<PublishedPaperModel> papersList = null;
			papersList = new PublishedPaperDao().papersByStudentId(studentId);
			
			request.setAttribute("papers", papersList);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/PPapersUpload.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int studentId = ((StudentModel)session.getAttribute("user")).getId();
		ArrayList<PublishedPaperModel> papersList = null;
		papersList = new PublishedPaperDao().papersByStudentId(studentId);
		
		request.setAttribute("papers", papersList);

		try {
			paperUpload(request, response);
		} catch (FileUploadException e) {
			e.printStackTrace();
			System.out.println("Upload did not complete successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to write upload to file");
		}
	}
	
	protected void paperUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		RequestDispatcher view = null;
		synchronized (session) {
			session.removeAttribute("formError");
			session.removeAttribute("success");
		
			ServletContext servletContext = this.getServletConfig().getServletContext();
			
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
	
			// Configure a repository (to ensure a secure temp location is used)
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
	
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
	
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			String uploadTitle = "";
			String fileName = "";
			String contentType = "";
			
			Iterator<FileItem> iter = items.iterator();
			FileItem item = null;
			while (iter.hasNext()) {
			    item = iter.next();
	
			    if(item.isFormField()) {
			        String name = item.getFieldName();
			        String value = item.getString();
			        if(name.equals("title")) {
			        	uploadTitle = value;
			        }
			    } else {
			    	fileName = item.getName();
			    	contentType = item.getContentType();
			    	if(verifyInputs(uploadTitle, fileName, contentType, request, response, session, view)) {
			    		File savedFile = new File(servletContext.getRealPath("/")+fileName);
			    		item.write(savedFile);
			    		storeUpload(uploadTitle, fileName, request, response, session, view);
			    	} else {
			    		return;
			    	}
			    }
			}
		}
	}
	
	protected boolean verifyInputs(String uploadTitle, String fileName, String contentType, HttpServletRequest request, HttpServletResponse response, HttpSession session, RequestDispatcher view) throws ServletException, IOException {
		if(uploadTitle.isEmpty() && fileName.isEmpty()) {
			session.setAttribute("formError", 2);
			view = request.getRequestDispatcher("WEB-INF/PPapersUpload.jsp");
			view.forward(request, response);
			return false;
		} else if(uploadTitle.isEmpty()) {
			session.setAttribute("formError", 3);
			view = request.getRequestDispatcher("WEB-INF/PPapersUpload.jsp");
			view.forward(request, response);
			return false;
		} else if(fileName.isEmpty()) {
			session.setAttribute("formError", 4);
			view = request.getRequestDispatcher("WEB-INF/PPapersUpload.jsp");
			view.forward(request, response);
			return false;
		} else if(!(contentType.equals("application/pdf") || contentType.equals("application/msword") || contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))) {
			session.setAttribute("formError", 5);
			view = request.getRequestDispatcher("WEB-INF/PPapersUpload.jsp");
			view.forward(request, response);
			return false;
		} else {
			return true;
		}
	}
	
	protected void storeUpload(String uploadTitle, String fileName, HttpServletRequest request, HttpServletResponse response, HttpSession session, RequestDispatcher view) throws ServletException, IOException {
		PublishedPaperModel paper = null;
		StudentModel user = (StudentModel) session.getAttribute("user");
		int studentId = user.getId();
		paper = new PublishedPaperModel(studentId, uploadTitle);
		paper.setFileName(fileName);
		if(new PublishedPaperDao().insertPaperDetails(paper)) {
			session.setAttribute("success", 1);
			view = request.getRequestDispatcher("WEB-INF/PPapersUpload.jsp");
			view.forward(request, response);
		}
	}

}
