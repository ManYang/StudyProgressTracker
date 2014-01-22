package edu.memphis.cardinal;

public class AdminModel {

	private int id;
	private String password;
	private String username;
	
	public AdminModel(int id, String password, String username) {		
		this.id = id;
		this.password = password;
		this.username = username;		
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
