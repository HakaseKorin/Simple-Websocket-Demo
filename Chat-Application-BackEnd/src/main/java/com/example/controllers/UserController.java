package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    @ResponseBody
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public User login(@RequestBody String username, String password){
        return userService.getUserByEmailAndPassword(username,password);
    }

    @PutMapping("/user")
    @ResponseBody
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    // @DeleteMapping("/user")
    public void deleteUser(User user){
        userService.deleteUser(user);
    }
}
