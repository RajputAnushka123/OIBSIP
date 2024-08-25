package bean;

public class User {
	private String name;
	private String email;
	private String username;
    private String password;
    private String mobileno;
    private String gender;
    
    @Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", mobileno=" + mobileno + ", gender=" + gender + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
     public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String moblieno) {
		this.mobileno = moblieno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
