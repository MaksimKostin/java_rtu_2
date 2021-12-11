package com.example.practice_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import com.example.practice_5.model.Message;
import com.example.practice_5.service.MessageService;

@RestController
public class WebSocketController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/webs")
    @SendTo("/topic/messages")
    public Message send(Message message) {
        messageService.saveAndSendMessage(message);
        return new Message("Process...");
    }


}
