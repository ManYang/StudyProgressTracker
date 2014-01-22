package edu.memphis.cardinal;


import java.sql.*;
import java.util.Vector;

public class Dao {

	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	public Dao() {
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

//--------------------------------------------------------------------------------------------------
public Vector<Grade> selectGrade(int stuID) {
		Connection con = null;
		ResultSet rs = null;
		Vector<Grade> grade = new Vector<Grade>();

		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			//rs = st.executeQuery("select Grade.id_student,username,Course.Course_Number,Course_Name,grade,status from cardinal.Student inner join cardinal.Grade on Student.id_student=Grade.id_student inner join cardinal.Course on Grade.Course_Number=Course.Course_Number;");
			rs = st.executeQuery("select Grade.id_student,username,Course_Number,Course_Name,grade,status from cardinal.Student inner join cardinal.Grade on Student.id_student=Grade.id_student inner join cardinal.Course on id_course=Course_Number where Grade.id_student="+stuID+";");

			while (rs.next()) {
				int sID=rs.getInt("id_student");
				String sName = rs.getString("username"); 
				String cID=rs.getString("Course_Number");
				String cName=rs.getString("Course_Name");
				String sGrade=rs.getString("grade");
				int status=rs.getInt("status");
				grade.add(new Grade(sID,sName,cID,cName,sGrade,status));
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
		
		return grade;
	}
//--------------------------------------------------------------------------------------------
public Vector<Grade> selectGradeByUserName(String userName) {
	Connection con = null;
	ResultSet rs = null;
	Vector<Grade> grade = new Vector<Grade>();

	try {
		con = DriverManager.getConnection(url+db, user, pass);
		Statement st = con.createStatement();
		//rs = st.executeQuery("select Grade.id_student,username,Course.Course_Number,Course_Name,grade,status from cardinal.Student inner join cardinal.Grade on Student.id_student=Grade.id_student inner join cardinal.Course on Grade.Course_Number=Course.Course_Number;");
		//rs = st.executeQuery("select Grade.id_student,username,Course.Course_Number,Course_Name,grade,status from cardinal.Student inner join cardinal.Grade on Student.id_student=Grade.id_student inner join cardinal.Course on Grade.Course_Number=Course.Course_Number where Student.username="+userName+";");
		rs = st.executeQuery("select Grade.id_student,username,Course_Number,Course_Name,grade,status from cardinal.Student inner join cardinal.Grade on Student.id_student=Grade.id_student inner join cardinal.Course on id_course=Course_Number where Student.username='"+userName+"';");

		while (rs.next()) {
			int sID=rs.getInt("id_student");
			String sName = rs.getString("username"); 
			String cID=rs.getString("Course_Number");
			String cName=rs.getString("Course_Name");
			String sGrade=rs.getString("grade");
			int status=rs.getInt("status");
			grade.add(new Grade(sID,sName,cID,cName,sGrade,status));
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
	
	return grade;
}
//-------------------------------------------------------------------------------------------------
public void comfirmGrade(int studentID,String courseID, int status) {
	Connection con = null;
	try {
		con = DriverManager.getConnection(url+db, user, pass);
		Statement st = con.createStatement();
		//st.executeUpdate("insert into cardinal.Grade value("+studentID+","+courseID+",'"+grade+"',0);");
		//st.executeUpdate("UPDATE `cardinal`.`Grade` SET `status`='"+status+"' WHERE `id_student`='"+studentID+"'and `Course_Number`='"+courseID+"';");
		st.executeUpdate("update cardinal.Grade set status="+status+" where id_student="+studentID+" and id_course='"+courseID+"';");

		
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
	
	
}
//--------------------------------------------------------------------------------------------------


public void editGrade(int studentID,String courseID,String grade) {
	Connection con = null;
	try {
		con = DriverManager.getConnection(url+db, user, pass);
		Statement st = con.createStatement();
		//st.executeUpdate("insert into cardinal.Grade value("+studentID+","+courseID+",'"+grade+"',0);");
		st.executeUpdate("UPDATE `cardinal`.`Grade` SET `grade`='"+grade+"' WHERE `id_student`='"+studentID+"'and `id_course`='"+courseID+"';");
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
	
	
}
	



}


