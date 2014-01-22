package edu.memphis.cardinal;

import java.sql.*;
import java.math.BigInteger;
import java.security.SecureRandom;

public class FacultyAddStudentDao {
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";		
	
	//need user interaction, and figure how to reset database on first arrival
	
	public FacultyAddStudentDao() {
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
	public void update(String student_name, String password, String program) throws SQLException{

		Connection con = null;
		   			
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO `cardinal`.`Student` (`username`, `password`,`program`) VALUES ('" + student_name+"', '" +password+"', '"+ program+"');");		
	}
		
		finally{
			con.close();
		}
	}
}
