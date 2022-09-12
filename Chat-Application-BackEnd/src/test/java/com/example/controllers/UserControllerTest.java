package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    private User user;

    @BeforeEach
    public void init(){
        user = new User(1, "email", "password", "display name", new HashSet<>(), new HashSet<>());
    }

    @Test
    void createUser() {
        userController.createUser(user);
        verify(userService).createUser(user);
    }

//    @Test
//    void login() {
//        when(userService.getUserByEmailAndPassword(anyString(),anyString())).thenReturn(user);
//        User result = userController.login("username","password");
//        assertEquals(user,result);
//    }

    @Test
    void updateUser() {
        userController.updateUser(user);
        verify(userService).updateUser(user);
    }

    @Test
    void deleteUser() {
        userController.deleteUser(user);
        verify(userService).deleteUser(user);
    }
}