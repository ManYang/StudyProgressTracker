package edu.memphis.cardinal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;


public class AddDelFacultyDao {
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "alpha_cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";		
	
	public  AddDelFacultyDao(){
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
			finally{ }
			}
		}
		public void add(FacultyModel faculty) throws SQLException{
			Connection con = null;
			   
			try {
				con = DriverManager.getConnection(url+db, user, pass);
				Statement st = con.createStatement();
				st.executeUpdate("INSERT INTO `cardinal`.`Faculty` (`username`, `password`) VALUES ('" + faculty.getUsername() +"', '" +faculty.getPassword()+"');");		
		}
			
			finally{
				con.close();
			}
		}
		public void delete(int i) throws SQLException{
			Connection con = null;
			   
			try {
				con = DriverManager.getConnection(url+db, user, pass);
				Statement st = con.createStatement();
				st.executeUpdate("DELETE FROM `cardinal`.`Faculty` WHERE `id_faculty`='"+i+"';");		
		}
			
			finally{
				con.close();
			}
		}		
		
		public  ArrayList<FacultyModel> showAll() throws SQLException{
			Connection con = null;
			ArrayList<FacultyModel> facultyAll= new ArrayList<FacultyModel>();
			try{
				con = DriverManager.getConnection(url+db, user, pass);
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("SELECT * FROM `cardinal`.`Faculty` ;");
				while(rs.next()){
					FacultyModel facultyModel=new FacultyModel();
					facultyModel.setId(rs.getInt("id_faculty"));
					facultyModel.setUsername(rs.getString("username"));
					facultyAll.add(facultyModel);
				}
				}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				con.close();
			}			
			return facultyAll;	
		}
}

