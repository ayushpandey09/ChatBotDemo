package com.example.chatbot.entity;

public class Message {

	private String senderName;
	private String content;
	
	
	
	public Message(String senderName, String content) {
		super();
		this.senderName = senderName;
		this.content = content;
	}
	
	public Message() {
		super();
	}
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
