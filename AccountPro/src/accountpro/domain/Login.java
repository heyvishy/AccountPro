package accountpro.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {

	@NotEmpty
	private String userid="vishal";
	
	@NotEmpty
	private String password="password";

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
