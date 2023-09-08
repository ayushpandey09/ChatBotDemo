package com.example.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.entity.Menu;
import com.example.chatbot.repo.MenuRepo;

@Service
public class MenuServices {

	@Autowired
	MenuRepo menurepo;
	
	public Menu getMenuById(Integer id) {
		
		return menurepo.findById(id).orElseThrow(null);
	}
}
