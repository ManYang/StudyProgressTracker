package edu.memphis.cardinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDao {
	
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	
	//need user interaction, and figure how to reset database on first arrival
	
	public CourseDao() {
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
	
	// gets all courses associated with a user with name username in database
	public ArrayList<Course> getCourses(String username)
	{
		ArrayList<Course> courses = new ArrayList<Course>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT `Course_by_Student`.`Course_Number`, `Grade`, `Course_Name`, `Prerequisites`, `Department` FROM `cardinal`.`Course_by_Student`" + 
									"INNER JOIN `cardinal`.`Course`" +
									"ON `cardinal`.`Course_by_Student`.`Course_Number` = `cardinal`.`Course`.`Course_Number`" +
									"WHERE `username` = '" + username + "' ORDER BY `Course_Number`;");
			while(rs.next())
			{
				String number = rs.getString("Course_Number");
				String grade = rs.getString("Grade");
				String name = rs.getString("Course_Name");
				String prereq = rs.getString("Prerequisites");
				String dept = rs.getString("Department");
				courses.add(new Course(number, name, grade, prereq, dept));
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
	
	public ArrayList<Course> getCoursesLike(String num, String dept)
	{
ArrayList<Course> courses = new ArrayList<Course>();
		
		Connection con = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT `Course`.`Course_Number`, `Course_Name`, `Prerequisites`, `Department` FROM `cardinal`.`Course`" + 
									"WHERE `Course_Number` LIKE '%" + num + "%' AND `Department` LIKE '%" + dept + "%' ORDER BY `Course_Number`;");
			while(rs.next())
			{
				String number = rs.getString("Course_Number");
				String name = rs.getString("Course_Name");
				String prereq = rs.getString("Prerequisites");
				String deptm = rs.getString("Department");
				courses.add(new Course(number, name, "", prereq, deptm));
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
	
	public int insertCourse(Course c, String username)
	{
		Connection con = null;
		ResultSet rs = null;
		int ret = -1;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * from `cardinal`.`Course` WHERE `Course_Number` = '" + c.number + "'");
			st = con.createStatement();
			System.out.println("out of select");
			if(rs.isBeforeFirst())
			{
				System.out.println("before first");
				st.executeUpdate("INSERT INTO `cardinal`.`Course_by_Student` VALUES ('" + username + "', '" + c.number + "', '')");
				ret = 1;
			}
			else
			{
				System.out.println("not");
				ret = 0;
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
		
		return ret;
	}

	public int deleteCourse(String c, String username)
	{
		Connection con = null;
		int ret = -1;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			
			String temp = "DELETE FROM `cardinal`.`Course_by_Student` WHERE `Course_Number` = '" + c + "' AND `username` = '" + username + "'";
			System.out.println(temp);
			st.executeUpdate(temp);
			ret = 1;
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
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return ret;
	}
	
}
