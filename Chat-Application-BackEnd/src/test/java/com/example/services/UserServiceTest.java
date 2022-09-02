package com.example.services;

import com.example.models.User;
import com.example.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        user = new User("username", "password", "JohnDoe", "JohnDoe@email.com");
    }

    @Test
    void createUser() {
        userService.createUser(user);
        verify(userRepository).save(user);
    }

    @Test
    void getUserByUsernameAndPassword() {
        when(userRepository.getUserByUsernameAndPassword(any(String.class),any(String.class))).thenReturn(user);
        User result = userService.getUserByUsernameAndPassword("username", "password");
        assertEquals(user, result);
    }

    @Test
    void getUserByUsernameAndPassword_Returns_Null(){
        when(userRepository.getUserByUsernameAndPassword(any(String.class),any(String.class))).thenReturn(null);
        User result = userService.getUserByUsernameAndPassword("dummy", "dummy");
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