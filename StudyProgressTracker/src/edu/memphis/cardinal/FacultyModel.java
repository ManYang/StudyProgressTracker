package edu.memphis.cardinal;

public class FacultyModel {

	private int id;
	private String password;
	private String username;
	
	public FacultyModel(int id, String password, String username) {		
		this.id = id;
		this.password = password;
		this.username = username;		
	}
	public FacultyModel(String username, String password){
		this.username=username;
		this.password=password;
	}
//add a blank initialize	
	public FacultyModel(){
		
	}
	public int getId() {		
		return id;		
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

}
