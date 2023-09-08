package com.example.chatbot.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MessageRequest {

	private String model;
    private List<Message> messages;

    public MessageRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }
    
    

	public MessageRequest() {
		super();
	}



	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
    
    
	
}
