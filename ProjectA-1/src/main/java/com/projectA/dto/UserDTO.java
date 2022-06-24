package com.projectA.dto;

import java.sql.Timestamp;

/*`email` varchar(50) not NULL ,
`password` varchar(50) DEFAULT NULL,
`name` varchar(50) DEFAULT NULL,
`address_d`varchar(200) DEFAULT NULL,
`phone` varchar(20) DEFAULT NULL,
`grade` varchar(20) default null,
`member_since` date default CURRENT_TIMESTAMP ,
PRIMARY KEY (`email`)*/

public class UserDTO {

	String email;
	String password;
	String name;
	String address_d;
	String phone;
	String grade;
	Timestamp member_since;
	
	
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", password=" + password + ", name=" + name + ", address_d=" + address_d
				+ ", phone=" + phone + ", grade=" + grade + ", member_since=" + member_since + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress_d() {
		return address_d;
	}
	public void setAddress_d(String address_d) {
		this.address_d = address_d;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Timestamp getMember_since() {
		return member_since;
	}
	public void setMember_since(Timestamp member_since) {
		this.member_since = member_since;
	}
	
	
}
