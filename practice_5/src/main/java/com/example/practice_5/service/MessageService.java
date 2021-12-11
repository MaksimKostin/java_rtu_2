package com.example.practice_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.example.practice_5.entity.MessageEntity;
import com.example.practice_5.model.Message;
import com.example.practice_5.repo.MessageRepository;
import com.example.practice_5.util.MessageSender;

@Service
public class MessageService {

    @Autowired
    private MessageSender messageSender;
    @Autowired
    private MessageRepository messageRepository;

    @Async
    public void saveAndSendMessage(Message message) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageRepository.save(new MessageEntity(message));
        messageSender.sendMessage(message);
    }

}
