package edu.memphis.cardinal;

import java.sql.*;

public class FacultyDao {

	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	
	public FacultyDao() {
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
	 * Queries the database for a Faculty entry by ID
	 * @param facultyId The id of the Faculty entry as stored in the db
	 * @return A FacultyModel object corresponding to facultyId. Object is null if no Faculty found in db
	 */
	public FacultyModel facultyById(int facultyId)
	{
		Connection con = null;
		ResultSet rs = null;
		
		FacultyModel faculty = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinal`.`Faculty` WHERE `id_faculty` = '" + facultyId + "'");
			if(rs.next())
			{
				faculty = new FacultyModel(rs.getInt("id_faculty"), rs.getString("password"), rs.getString("username"));
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
		
		return faculty;
	}
	
	/**
	 * Queries the database for a Faculty entry by username
	 * @param username The username of the Faculty entry as stored in the db
	 * @return A FacultyModel object corresponding to username. Object is null if no Faculty found in db
	 */
	public FacultyModel facultyByUsername(String username)
	{
		Connection con = null;
		ResultSet rs = null;
		
		FacultyModel faculty = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinal`.`Faculty` WHERE `username` = '" + username + "'");
			if(rs.next())
			{
				faculty = new FacultyModel(rs.getInt("id_faculty"), rs.getString("password"), rs.getString("username"));
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
		
		return faculty;
	}
	
	public void add(String username, String password, String phone, String address) throws SQLException{
		Connection con = null;
		   
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO `cardinal`.`Faculty` (`username`, `password`,`phone`,`address`) VALUES ('" + username + "', '" + password +"', '"+ phone+"', '"+address+"');");	
	}	
		finally{
			con.close();
		}
	}
	
	public void delete(FacultyModel faculty) throws SQLException{
		Connection con = null;
		   
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			st.executeUpdate("DELETE FROM `cardinal`.`Faculty` WHERE `id_faculty`='"+faculty.getId()+"';");		
	}
		
		finally{
			con.close();
		}
	}
	
	public boolean updatePassword(int facultyId, String newPass) {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			
			st.executeUpdate("UPDATE `cardinal`.`Faculty` SET `password`= '" + newPass + "' WHERE `id_faculty`= " + facultyId + ";");
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
