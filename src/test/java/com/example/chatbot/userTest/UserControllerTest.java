package com.example.chatbot.userTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.chatbot.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc

public class UserControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userv;
    
 
    @Test
    public void testPostEndpoint() throws Exception {
    	String requestBody = "{\n"
    			+ "    \"id\":123,\n"
    			+ "    \"emp_name\": \"suraj\",\n"
    			+ "    \"emp_role\": \"SDE\",\n"
    			+ "    \"emp_email\": \"suraj@gmail.com\",\n"
    			+ "    \"phone\": \"9999999999\"\n"
    			+ "}";

        mockMvc.perform(MockMvcRequestBuilders
            .post("/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//          andExpect(MockMvcResultMatchers.jsonPath("$.response-property").value("expected-response-value"));
        
        
        
        
    }
}