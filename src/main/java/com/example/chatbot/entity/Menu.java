package com.example.chatbot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Menu {

	@Id
	private int menuId;
	private String menuName;
	private String description;
	public Menu(int menuId, String menuName, String description) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.description = description;
	}
	public Menu() {
		super();
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
