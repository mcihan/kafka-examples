package com.cihan.kafkaproducerconsumer.consumer;

import com.cihan.kafkaproducerconsumer.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserConsumer {
    @KafkaListener(topics = "USER_TOPIC")
    public void consume(User user) {
        log.info("incoming user :" + user);
    }
}
