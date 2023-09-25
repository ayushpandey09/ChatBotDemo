package com.example.chatbot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	private Integer employee_id;
	private String emp_name;
	private String designation;
	private String email;
	private String location;
	private Integer manager_id;
	private String nwa_code;
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Employee(Integer employee_id, String emp_name, String designation, String email, String location,
			Integer manager_id, String nwa_code) {
		super();
		this.employee_id = employee_id;
		this.emp_name = emp_name;
		this.designation = designation;
		this.email = email;
		this.location = location;
		this.manager_id = manager_id;
		this.nwa_code = nwa_code;
	}
	public Employee() {
		super();
	}
	public String getNwa_code() {
		return nwa_code;
	}
	public void setNwa_code(String nwa_code) {
		this.nwa_code = nwa_code;
	}
	
	
	
}
