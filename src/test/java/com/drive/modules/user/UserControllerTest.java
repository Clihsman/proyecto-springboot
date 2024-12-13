package com.drive.modules.user;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    private void setup() {/* 
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("isaac", null,
                List.of());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        */
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .header("Authorization", "Bearer eyJhbGciOiJIUzM4NCJ9.eyJ1c2VySWQiOjEsImVtYWlsIjoiY2xpaHNtYW4uY3NAZ21haWwuY29tIiwic3ViIjoiY2xpaHNtYW4uY3NAZ21haWwuY29tIiwiaWF0IjoxNzMzOTQ3NjYxLCJleHAiOjE3MzQ1NTI0NjF9.pRR1BhnNjsBSIHqMQyFxL4-2HSVMlsiOoEdScWbgwvIshOxCTsB3WE3s1MC02sLX")
                .contentType(MediaType.APPLICATION_JSON))           
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
