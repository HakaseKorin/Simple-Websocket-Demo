package com.example.controllers;

import com.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WebController {

    private final SimpMessagingTemplate template;

    @Autowired
    public WebController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/send/{room}")
    public void chatMessage(Message message, @DestinationVariable Integer room) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm a");
        String formattedDate = now.format(formatter);

        this.template.convertAndSend(
                String.format("topic/%s",room.toString()),
                new Message(message.getUsername(), message.getContent(), formattedDate));
    }

    @MessageMapping("/participant/{room}")
    public void participantUpdate(@DestinationVariable Integer room, String displayName, String message) {
        this.template.convertAndSend(
                String.format("/topic/%s/participant",room.toString()),
                String.format("%s %s",displayName, message));
    }
}
