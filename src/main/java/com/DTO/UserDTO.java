package com.DTO;

import lombok.Data;

@Data
public class UserDTO {

	private String uname;
	private String email;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	private String gender;
	private String uaddress;
	@Override
	public String toString() {
		return "UserDTO [uname=" + uname + ", email=" + email + ", gender=" + gender + ", uaddress=" + uaddress + "]";
	}
	
	
}
