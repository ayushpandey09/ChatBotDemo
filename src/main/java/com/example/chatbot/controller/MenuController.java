package com.example.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.entity.Menu;
import com.example.chatbot.service.MenuServices;

@RestController
@RequestMapping("/company")
public class MenuController {
	
	@Autowired
	MenuServices menuservice;
	
	@GetMapping("/menu/{id}")
	public ResponseEntity<Menu> getMenu(@PathVariable Integer id){
		return ResponseEntity.ok(menuservice.getMenuById(id));
	}
}


