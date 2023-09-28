package com.example.chatbot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.entity.User;
import com.example.chatbot.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	UserService userServ;
	
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user ){
		
		userServ.createUser(user);
		return ResponseEntity.ok(user);
	}
	


}
