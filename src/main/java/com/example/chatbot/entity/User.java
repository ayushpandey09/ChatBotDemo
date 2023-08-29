package com.example.chatbot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	
	int id;
	String empName;
	String empRole;
	String empEmail;
	String Phone;
	
	
	
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
		this.Phone = phone;
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
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}

}

