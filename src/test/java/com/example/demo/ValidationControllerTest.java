package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPasswordQualityEndpoint() throws Exception {
        String requestBody = "{\"password\":\"12345\"}";
        
        mockMvc.perform(post("/api/password-quality")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quality").value("Weak"));
                
        requestBody = "{\"password\":\"Abc123def456!\"}";
        
        mockMvc.perform(post("/api/password-quality")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quality").value("Strong"));
    }

    @Test
    void testEmailValidEndpoint() throws Exception {
        String requestBody = "{\"email\":\"test@example.com\"}";
        
        mockMvc.perform(post("/api/email-address-valid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isValid").value(true));
                
        requestBody = "{\"email\":\"not-an-email\"}";
        
        mockMvc.perform(post("/api/email-address-valid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isValid").value(false));
    }
}