package com.catchmeon.catchmeonjwt.controller;

import com.catchmeon.catchmeonjwt.models.request.AuthenticationRequest;
import com.catchmeon.catchmeonjwt.services.UserService;
import com.catchmeon.catchmeonjwt.util.JwtUtil;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloResourceTest {

    @Autowired
    private MockMvc mockMvc;


    @Mock
    private UserService service;

    @Mock
    private HelloResource helloService;

    @InjectMocks
    private HelloResource helloResource;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloResource)
                .build();
    }


    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetHelloWorld() {

        String expected = "Hello world";

        String result = helloResource.hello();

        assertEquals(expected, result);
    }


    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {
        Mockito.mock(HelloResource.class);

        String username = "elonmusk";
        String password = "azeaze";


        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
                .content(body).header("Content-type", "application/json"))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.replace("{\"access_token\": \"", "");
        String token = response.replace("\"}", "");

    }


    @Test
    public void shouldAllowAccessToHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(status().isOk());
    }


    @Test
    public void testgetOwnTweetOK() throws Exception {

        ResponseEntity expected = new ResponseEntity("{0:{}}", HttpStatus.OK);
        ResponseEntity<?> result = helloResource.getOwnTweet("darius");

        assertEquals(expected.getStatusCode(), result.getStatusCode());
    }

}
