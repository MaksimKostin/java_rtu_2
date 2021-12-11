package com.example.practice_5.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import com.example.practice_5.model.Message;

@Component
public class MessageSender {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendMessage(Message message) {
        try {
            template.convertAndSend("/topic/messages", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
