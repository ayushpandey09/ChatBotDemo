package com.example.chatbot.employeeTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.chatbot.service.EmployeeService;

@SpringBootTest
@AutoConfigureMockMvc

public class EmployeeControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
//    @MockBean
//    private EmployeeService empServ;
    
    @Test
    public void testPostEndpoint() throws Exception{
    	String requestBody = "{\n"
    			+ "   \n"
    			+ "    \"sendername\":\"User\",\n"
    			+ "    \"content\":\"who is my manager\"\n"
    			+ "}";

        mockMvc.perform(MockMvcRequestBuilders
            .post("/chatbot/question")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }
    
    @Test
    public void testGetEndpoint() throws Exception{
    	mockMvc.perform(MockMvcRequestBuilders
                .get("/chatbot/questionresponse"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.property-name").value("expected-value"));
    }
}