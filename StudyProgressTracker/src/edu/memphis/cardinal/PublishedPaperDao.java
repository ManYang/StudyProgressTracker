package edu.memphis.cardinal;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PublishedPaperDao {
	
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	
	public PublishedPaperDao() {
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
	 * Queries the database to store details about a published paper
	 * @param paper An object representing the paper that contains the information to store in the db
	 */
	public boolean insertPaperDetails(PublishedPaperModel paper)
	{
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			String insertQuery = "INSERT INTO `cardinal`.`Published_Papers` (`id_student`, `title`, `file_name`)" +
						"VALUES (" +paper.getStudentId()+ ", '" +paper.getTitle().replace("'", "\\'")+ "', '" +paper.getFileName()+ "')";
			Statement st = con.createStatement();
			st.execute(insertQuery);
		} catch(SQLException e){ 
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
				e.printStackTrace();
			}			
		}
		return true;
	}
	
	public ArrayList<PublishedPaperModel> papersByStudentId(int studentId)
	{
		Connection con = null;
		ResultSet rs = null;
		
		ArrayList<PublishedPaperModel> papersList = new ArrayList<PublishedPaperModel>();
		PublishedPaperModel paper = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinal`.`Published_Papers` WHERE `id_student` = " + studentId);
			while(rs.next())
			{
				paper = new PublishedPaperModel(rs.getInt("id_student"), rs.getString("title"));
				paper.setFileName(rs.getString("file_name"));
				paper.setPaperId(rs.getInt("id_published_paper"));
				String dateStored = new SimpleDateFormat("MM/dd/yyyy").format(rs.getTimestamp("date_stored"));
				paper.setStoredDate(dateStored);
				papersList.add(paper);
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
		
		return papersList;
	}
	
	public PublishedPaperModel paperByPaperId(int paperId)
	{
		Connection con = null;
		ResultSet rs = null;
		
		PublishedPaperModel paper = null;
		
		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinal`.`Published_Papers` WHERE `id_published_paper` = " + paperId);
			while(rs.next())
			{
				paper = new PublishedPaperModel(rs.getInt("id_student"), rs.getString("title"));
				paper.setFileName(rs.getString("file_name"));
				paper.setPaperId(rs.getInt("id_published_paper"));
				String dateStored = new SimpleDateFormat("MM/dd/yyyy").format(rs.getTimestamp("date_stored"));
				paper.setStoredDate(dateStored);
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
		
		return paper;
	}

}
