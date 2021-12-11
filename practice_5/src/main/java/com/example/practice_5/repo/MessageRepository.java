package com.example.practice_5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practice_5.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
