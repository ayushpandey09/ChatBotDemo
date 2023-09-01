package com.example.chatbot.controller;

import com.example.chatbot.dto.MessageRequest;
import com.example.chatbot.dto.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class ChatBotController {

	@Value("${openai.model}")
	private String model;

	@Value(("${openai.api.url}"))
	private String apiURL;

	@Autowired
	private RestTemplate template;

	@GetMapping("/chat")
	public String chat(@RequestParam("prompt") String prompt){
		MessageRequest msgReq  = new MessageRequest(model,prompt);
	    MessageResponse msgRes = template.postForObject(apiURL,msgReq,MessageResponse.class);
        return msgRes.getChoices().get(0).getMessage().getContent();
	}
}
