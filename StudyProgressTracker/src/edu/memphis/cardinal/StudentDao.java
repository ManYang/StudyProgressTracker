package edu.memphis.cardinal;

import java.sql.*;

public class StudentDao {

	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	
	public StudentDao() {
		// Load the driver class.
		if (driverObject == null) {
			try {
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
	
	/**
	 * Queries the database for a Student entry by ID
	 * @param studentId The id of the Student entry as stored in the db
	 * @return A StudentModel object corresponding to studentId. Object is null if no Student found in db
	 */
	public StudentModel studentById(int studentId)
	{
		Connection con = null;
		ResultSet rs = null;
		
		StudentModel student = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinal`.`Student` WHERE `id_student` = '" + studentId + "'");
			if(rs.next())
			{
				student = new StudentModel(rs.getInt("id_student"), rs.getString("password"), rs.getString("username"));
				student.setProgram(rs.getString("Program"));
			}
		} catch(SQLException e){ 
			while (e != null) {
				System.err.println("SQL EXCEPTION:");
				System.err.println ("Error msg: " + e.getMessage()); 
				System.err.println ("SQLSTATE: " + e.getSQLState()); 
				System.err.println ("Error code: " + e.getErrorCode()); 
				e.printStackTrace(); 
				e = e.getNextException();
			}
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return student;
	}
	
	/**
	 * Queries the database for a Student entry by username
	 * @param username The username of the Student entry as stored in the db
	 * @return A StudentModel object corresponding to username. Object is null if no Student found in db
	 */
	public StudentModel studentByUsername(String username)
	{
		Connection con = null;
		ResultSet rs = null;
		
		StudentModel student = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinal`.`Student` WHERE `username` = '" + username + "'");
			if(rs.next())
			{
				student = new StudentModel(rs.getInt("id_student"), rs.getString("password"), rs.getString("username"));
				student.setProgram(rs.getString("Program"));
			}
		} catch(SQLException e){ 
			while (e != null) {
				System.err.println("SQL EXCEPTION:");
				System.err.println ("Error msg: " + e.getMessage()); 
				System.err.println ("SQLSTATE: " + e.getSQLState()); 
				System.err.println ("Error code: " + e.getErrorCode()); 
				e.printStackTrace(); 
				e = e.getNextException();
			}
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return student;
	}
	
	public boolean updatePassword(int studentId, String newPass) {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			
			st.executeUpdate("UPDATE `cardinal`.`Student` SET `password`= '" + newPass + "' WHERE `id_student`= " + studentId + ";");
		}
		catch(SQLException e){ 
			while (e != null) {
				System.err.println("SQL EXCEPTION:");
				System.err.println ("Error msg: " + e.getMessage()); 
				System.err.println ("SQLSTATE: " + e.getSQLState()); 
				System.err.println ("Error code: " + e.getErrorCode()); 
				e.printStackTrace(); 
				e = e.getNextException();
				return false;
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return true;
	}
}
