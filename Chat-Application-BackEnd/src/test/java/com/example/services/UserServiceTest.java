package com.example.services;

import com.example.models.User;
import com.example.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    private User user;

    @BeforeEach
    public void init(){
        user = new User(1, "email", "password", "display name", new HashSet<>(), new HashSet<>());
    }

    @Test
    void createUser() {
        userService.createUser(user);
        verify(userRepository).save(user);
    }

    @Test
    void getUserByUsernameAndPassword() {
        when(userRepository.getUserByEmailAndPassword(any(String.class),any(String.class))).thenReturn(user);
        User result = userService.getUserByEmailAndPassword("username", "password");
        assertEquals(user, result);
    }

    @Test
    void getUserByUsernameAndPassword_Returns_Null(){
        when(userRepository.getUserByEmailAndPassword(any(String.class),any(String.class))).thenReturn(null);
        User result = userService.getUserByEmailAndPassword("dummy", "dummy");
        assertNull(result);
    }

    @Test
    void updateUser() {
        userService.updateUser(user);
        verify(userRepository).save(user);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(user);
        verify(userRepository).delete(user);
    }
}