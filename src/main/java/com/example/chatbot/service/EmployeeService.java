package com.example.chatbot.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.chatbot.entity.Employee;
import com.example.chatbot.entity.Message;
import com.example.chatbot.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepo empRepo;
	
	private JavaMailSender javaMailSender;
	
	@Autowired
    void EmailService(JavaMailSender javaMailSender) {
       this.javaMailSender = javaMailSender;
   }
	
	private List<String> chatMessages = new ArrayList<>();
	
	public void addMessage(Message msg) {
		chatMessages.add(msg.getSenderName() + ":" +" " + msg.getContent());

	}
	
	public List<String> getChatMessages(){
		return chatMessages;
	}
	
	public String endChatAndSendTranscript(String user_email) {
		StringBuilder transcriptBuilder = new StringBuilder();
		for(String msg : chatMessages) {
			transcriptBuilder.append(msg).append("\n");
		}
		
		chatMessages.clear();
		
		String transcript = transcriptBuilder.toString();
		
		
		sendEmail(user_email,"Chat Transcript",transcript);
		
		return transcript;
	}
	
	public void sendEmail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
		message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
	}
		

	public List<Employee> findManagerByEmpId(Integer empId){
		return empRepo.findManager(empId);
	}
	public List<Employee> findIThelp(String location){
		return empRepo.findIThelp(location);
	}
	public List<Employee> findNwaCode(Integer empId){
		return empRepo.findNwa(empId);
	}
	public int checkEmpId(Integer empId){
		return empRepo.checkEmpIDExistence(empId);
	}
	public int checkLocation(String location){
		return empRepo.checkLocationExistence(location);
	}
	
	
}
