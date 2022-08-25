package com.example.controllers;

import com.example.models.ChatMessage;
import com.example.models.Hello;
import com.example.models.Message;
import com.example.models.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WebController {

    @MessageMapping("/hello")
    @SendTo("/topic/hi")
    public Hello greeting(User user) throws Exception {
        return new Hello("Hi " + user.getName() + "!");
    }

    @MessageMapping("/send")
    @SendTo("/topic/message")
    public Message chatMessage(Message message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm a");
        String formattedDate = now.format(formatter);
        return new Message(message.getUsername(), message.getContent(), formattedDate.toString());
//        return new ChatMessage(String.format("%1$s [%2$s]: %3$s",message.getUsername(), formattedDate,message.getContent()));
    }
}
