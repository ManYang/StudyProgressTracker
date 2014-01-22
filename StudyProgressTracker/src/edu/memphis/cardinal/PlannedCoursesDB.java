package edu.memphis.cardinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.memphis.cardinal.PlannedCourses;

public class PlannedCoursesDB {

	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	
	public PlannedCoursesDB() {
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
	
	public void addPlannedCourses(PlannedCourses plannedCourses) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO cardinal.PlannedCourses (studentID, courseNum) VALUES (\"" + plannedCourses.getStudentID() + "\", \"" + plannedCourses.getCourseNum() + "\");");
			
		} catch(SQLException e) {
			System.out.println("addPlannedCourses(): StudentID = " + plannedCourses.getStudentID() + "; CourseNum = " + plannedCourses.getCourseNum());
			System.out.println("INSERT INTO cardinal.PlannedCourses (studentID, courseNum) VALUES (\"" + plannedCourses.getStudentID() + "\", \"" + plannedCourses.getCourseNum() + "\");");
			
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
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void deletePlannedCourses(PlannedCourses plannedCourses) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			st.executeUpdate("DELETE FROM cardinal.PlannedCourses WHERE studentID=\"" + plannedCourses.getStudentID() + "\" and courseNum=\"" + plannedCourses.getCourseNum() + "\";");
		} catch(SQLException e){
			System.out.println("deletePlannedCourses(): StudentID = " + plannedCourses.getStudentID() + "; CourseNum = " + plannedCourses.getCourseNum());
			System.out.println("DELETE FROM cardinal.PlannedCourses WHERE studentID=\"" + plannedCourses.getStudentID() + "\" and courseNum=\"" + plannedCourses.getCourseNum() + "\";");

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
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public boolean searchPlannedCourses(PlannedCourses plannedCourses) {
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT studentID, courseNum FROM cardinal.PlannedCourses WHERE studentID = \"" + plannedCourses.getStudentID() + "\" and courseNum = \"" + plannedCourses.getCourseNum() + "\";");
			System.out.println("SELECT studentID, courseNum FROM cardinal.PlannedCourses WHERE studentID = \"" + plannedCourses.getStudentID() + "\" and courseNum = \"" + plannedCourses.getCourseNum() + "\";");

			if (rs.next())
				return true;
		} catch(SQLException e){
			System.out.println("searchPlannedCourses(): StudentID = " + plannedCourses.getStudentID() + "; CourseNum = " + plannedCourses.getCourseNum());
			System.out.println("SELECT studentID, courseNum FROM cardinal.PlannedCourses WHERE studentID = \"" + plannedCourses.getStudentID() + "\" and courseNum = \"" + plannedCourses.getCourseNum() + "\";");

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
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
}
