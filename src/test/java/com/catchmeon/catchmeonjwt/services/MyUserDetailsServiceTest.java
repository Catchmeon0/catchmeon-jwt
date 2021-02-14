package com.catchmeon.catchmeonjwt.services;

import com.catchmeon.catchmeonjwt.models.UserCMO;
import com.google.cloud.firestore.Firestore;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@AutoConfigureMockMvc
public class MyUserDetailsServiceTest {

    @Mock
    private UserCMO user;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void TestgetUser() throws ExecutionException, InterruptedException {

        Mockito.when(user.getUsername()).thenReturn("darius");

        var userCMO  =new UserCMO();

        userCMO = userService.getUser("darius");

        assertEquals(user.getUsername(), userCMO.getUsername());

    }
}
