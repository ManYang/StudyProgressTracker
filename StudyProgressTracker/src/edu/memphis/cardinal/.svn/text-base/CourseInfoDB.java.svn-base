package edu.memphis.cardinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class CourseInfoDB {

	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	
	public CourseInfoDB() {
	// Load the driver class.
		if (driverObject == null) {
			try {
				// The newInstance() call is a work around for some broken Java implementations.
				driverObject = Class.forName(jdbcDriver).newInstance();
			} catch (ClassNotFoundException e) {
				// Couldn't find the driver class.
				// TODO Handle the error.
			} catch (Exception e) {
				// Other problems with loading the driver class.
				// TODO Handle the error.
			}
		}
	}
	
	public Vector<CourseInfo> getCourseInfo() {
		Connection con = null;
		ResultSet rs = null;
		Vector<CourseInfo> courses = new Vector<CourseInfo>();

		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM cardinal.CourseInfo;");
			
			while (rs.next()) {
				String courseNum = rs.getString("courseNum");
				String courseName = rs.getString("courseName");
				courses.add(new CourseInfo(courseNum, courseName));
			}
		} catch(SQLException e){ 
			while (e != null) {
				System.err.println("SQL EXCEPTION:");
				System.err.println ("Error msg: " + e.getMessage()); 
				System.err.println ("SQLSTATE: " + e.getSQLState()); 
				System.err.println ("Error code: " + e.getErrorCode()); 
				e.printStackTrace(); 
				e = e.getNextException(); // For drivers that support chained exceptions
			}
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return courses;
	}
}
