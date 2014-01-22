package edu.memphis.cardinal;

import java.sql.*;

public class AdminDao {

	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	
	public AdminDao() {
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
	 * Queries the database for a Admin entry by ID
	 * @param adminId The id of the Admin entry as stored in the db
	 * @return A AdminModel object corresponding to adminId. Object is null if no Admin found in db
	 */
	public AdminModel adminById(int adminId)
	{
		Connection con = null;
		ResultSet rs = null;
		
		AdminModel admin = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinal`.`Admin` WHERE `id_admin` = '" + adminId + "'");
			if(rs.next())
			{
				admin = new AdminModel(rs.getInt("id_admin"), rs.getString("password"), rs.getString("username"));
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
		
		return admin;
	}
	
	/**
	 * Queries the database for a Admin entry by username
	 * @param username The username of the Admin entry as stored in the db
	 * @return A AdminModel object corresponding to username. Object is null if no Admin found in db
	 */
	public AdminModel adminByUsername(String username)
	{
		Connection con = null;
		ResultSet rs = null;
		
		AdminModel admin = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinal`.`Admin` WHERE `username` = '" + username + "'");
			if(rs.next())
			{
				admin = new AdminModel(rs.getInt("id_admin"), rs.getString("password"), rs.getString("username"));
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
		
		return admin;
	}
	
	public boolean updatePassword(int adminId, String newPass) {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			
			st.executeUpdate("UPDATE `cardinal`.`Admin` SET `password`= '" + newPass + "' WHERE `id_admin`= " + adminId + ";");
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
