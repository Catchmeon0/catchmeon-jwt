package com.catchmeon.catchmeonjwt.controller;

import com.catchmeon.catchmeonjwt.services.UserService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloResourceTest {

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
                .build();}
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetHelloWorld() {

        String expected = "Hello world";

        String result = helloResource.hello();

        assertEquals(expected, result);
    }


    @Test
    public void testgetTweet() throws Exception {

        when(helloService.getTweet("darius")).thenReturn(new ResponseEntity(":)", HttpStatus.OK));

        mockMvc.perform(get("/getTweetFromUser"))
                .andExpect(status().isOk());

        verify(helloService).getTweet("darius");
    }

}

