package com.ELearning.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="login_info")
public class LoginBean {
	@Column(name="login_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int loginId;
	
//	public int getLoginId() {
//		return loginId;
//	}
//	public void setLoginId(int loginId) {
//		this.loginId = loginId;
//	}
	private String userName;
	private String pass;

	public LoginBean(String userName, String pass) {
	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getPass() {
//		return pass;
//	}
//	public void setPass(String pass) {
//		this.pass = pass;
//	}
//	public LoginBean(String userName, String pass) {
//		super();
//		this.userName = userName;
//		this.pass = pass;
//	}


}
