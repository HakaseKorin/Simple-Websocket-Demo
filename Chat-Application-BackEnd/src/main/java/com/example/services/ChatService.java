package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class ChatService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void sendChatMessage(String destination, MessageDTO messageDTO) {

    }
}
