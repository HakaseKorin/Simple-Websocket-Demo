package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
        TODO: change user DB to only track user's display information tying it to their user id
        Login will be handled by another service
     */

    @PostMapping("/user")
    @ResponseBody
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @Deprecated
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
