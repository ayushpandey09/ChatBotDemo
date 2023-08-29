package com.example.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.chatbot.entity.User;
import com.example.chatbot.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	
	@PostMapping("/adduser")
	public User createUser(@RequestBody User user ){
		 
		 return userRepo.save(user);
	}
}
