package com.example.chatbot.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.chatbot.entity.User;



public interface UserRepo extends CrudRepository<User, Integer>
{

}
