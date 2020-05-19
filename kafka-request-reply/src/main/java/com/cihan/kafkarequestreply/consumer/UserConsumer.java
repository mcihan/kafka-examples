package com.cihan.kafkarequestreply.consumer;

import com.cihan.kafkarequestreply.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {
    @KafkaListener(topics = "USER_TOPIC")
    @SendTo
    public User consumer(User user) throws InterruptedException {
        user.setInfo(user.getInfo() + "- information is consumed");
        return user;
    }
}
