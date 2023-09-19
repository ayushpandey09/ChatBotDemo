package com.example.chatbot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String empName;
	String empRole;
	String empEmail;
	String phone;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int id, String empName, String empRole, String empEmail, String phone) {
		super();
		this.id = id;
		this.empName = empName;
		this.empRole = empRole;
		this.empEmail = empEmail;
		this.phone = phone;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}

