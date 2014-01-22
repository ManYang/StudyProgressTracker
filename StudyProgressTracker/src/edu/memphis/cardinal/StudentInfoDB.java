package edu.memphis.cardinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import edu.memphis.cardinal.StudentInfo;

public class StudentInfoDB {

	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Object driverObject = null;
	private final static String url = "jdbc:mysql://141.225.11.129:3306/"; 
	private final static String db = "cardinal";
	private final static String user = "u_cardinal";
	private final static String pass = "nik6ITA";
	
	public StudentInfoDB() {
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
	
	public Vector<StudentInfo> getStudentInfo(StudentInfo studentInfo) {
		Connection con = null;
		ResultSet rs = null;
		Vector<StudentInfo> students = new Vector<StudentInfo>();

		try {
			con = DriverManager.getConnection(url+db, user, pass);
			Statement st = con.createStatement();
			if (studentInfo.getID() != 0) {
				rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE id_student =\"" + studentInfo.getID() + "\";");
			} else {
				if (studentInfo.getLastName() != null && !studentInfo.getLastName().equals("")) {
					if (studentInfo.getFirstName() != null && !studentInfo.getFirstName().equals("")) {
						if (studentInfo.getMajor() != null && !studentInfo.getMajor().equals("")) {
							if (studentInfo.getProgram() != null && !studentInfo.getProgram().equals("")) {
								System.out.println("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and first_name = \"" + studentInfo.getFirstName() + "\" and major = \"" + studentInfo.getMajor() + "\" and program = \"" + studentInfo.getProgram() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and first_name = \"" + studentInfo.getFirstName() + "\" and major = \"" + studentInfo.getMajor() + "\" and program = \"" + studentInfo.getProgram() + "\";");
							} else {
								System.out.println("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and first_name = \"" + studentInfo.getFirstName() + "\" and major = \"" + studentInfo.getMajor() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and first_name = \"" + studentInfo.getFirstName() + "\" and major = \"" + studentInfo.getMajor() + "\";");
							}
						} else {
							if (studentInfo.getProgram() != null && !studentInfo.getProgram().equals("")) {
								System.out.println("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and first_name = \"" + studentInfo.getFirstName() + "\" and program = \"" + studentInfo.getProgram() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and first_name = \"" + studentInfo.getFirstName() + "\" and program = \"" + studentInfo.getProgram() + "\";");
							} else {
								System.out.println("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and first_name = \"" + studentInfo.getFirstName() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and first_name = \"" + studentInfo.getFirstName() + "\";");
							}
						}
					} else {
						if (studentInfo.getMajor() != null && !studentInfo.getMajor().equals("")) {
							if (studentInfo.getProgram() != null && !studentInfo.getProgram().equals("")) {
								System.out.println("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and major = \"" + studentInfo.getMajor() + "\" and program = \"" + studentInfo.getProgram() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and major = \"" + studentInfo.getMajor() + "\" and program = \"" + studentInfo.getProgram() + "\";");
							} else {
								System.out.println("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and major = \"" + studentInfo.getMajor() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and major = \"" + studentInfo.getMajor() + "\";");
							}
						} else {
							if (studentInfo.getProgram() != null && !studentInfo.getProgram().equals("")) {
								System.out.println("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and program = \"" + studentInfo.getProgram() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\" and program = \"" + studentInfo.getProgram() + "\";");
							} else {
								System.out.println("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE last_name = \"" + studentInfo.getLastName() + "\";");
							}
						}
					}
				} else {
					if (studentInfo.getFirstName() != null && !studentInfo.getFirstName().equals("")) {
						if (studentInfo.getMajor() != null && !studentInfo.getMajor().equals("")) {
							if (studentInfo.getProgram() != null && !studentInfo.getProgram().equals("")) {
								System.out.println("SELECT * FROM cardinal.Student WHERE first_name = \"" + studentInfo.getFirstName() + "\" and major = \"" + studentInfo.getMajor() + "\" and program = \"" + studentInfo.getProgram() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE first_name = \"" + studentInfo.getFirstName() + "\" and major = \"" + studentInfo.getMajor() + "\" and program = \"" + studentInfo.getProgram() + "\";");
							} else {
								System.out.println("SELECT * FROM cardinal.Student WHERE first_name = \"" + studentInfo.getFirstName() + "\" and major = \"" + studentInfo.getMajor() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE first_name = \"" + studentInfo.getFirstName() + "\" and major = \"" + studentInfo.getMajor() + "\";");
							}
						} else {
							if (studentInfo.getProgram() != null && !studentInfo.getProgram().equals("")) {
								System.out.println("SELECT * FROM cardinal.Student WHERE first_name = \"" + studentInfo.getFirstName() + "\" and program = \"" + studentInfo.getProgram() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE first_name = \"" + studentInfo.getFirstName() + "\" and program = \"" + studentInfo.getProgram() + "\";");
							} else {
								System.out.println("SELECT * FROM cardinal.Student WHERE first_name = \"" + studentInfo.getFirstName() + "\";");
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE first_name = \"" + studentInfo.getFirstName() + "\";");
							}
						}
					} else {
						if (studentInfo.getMajor() != null && !studentInfo.getMajor().equals("")) {
							if (studentInfo.getProgram() != null && !studentInfo.getProgram().equals("")) {
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE major = \"" + studentInfo.getMajor() + "\" and program = \"" + studentInfo.getProgram() + "\";");
							} else {
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE major = \"" + studentInfo.getMajor() + "\";");
							}
						} else {
							if (studentInfo.getProgram() != null && !studentInfo.getProgram().equals("")) {
								rs = st.executeQuery("SELECT * FROM cardinal.Student WHERE program = \"" + studentInfo.getProgram() + "\";");
							} else {
								rs = st.executeQuery("SELECT * FROM cardinal.Student");
							}
						}
					}
				}
			}
			
			while (rs.next()) {
				int id = rs.getInt("id_student");
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String major = rs.getString("major");
				String program = rs.getString("program");
				double gpa = rs.getDouble("gpa");
				String department = rs.getString("department");
				students.add(new StudentInfo(id, firstName, lastName, major, program, gpa, department));
			}
		} catch(SQLException e) {
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
				if (rs != null)
				{
					rs.close();
				}
				if (con != null)
				{
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return students;
	}
}
