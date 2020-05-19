package com.cihan.kafkaproducerconsumer.controller;

import com.cihan.kafkaproducerconsumer.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserProduceController {
    private final KafkaTemplate<String, User> kafkaTemplate;

    @ResponseBody
    @PostMapping(value = "/produce-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void produce(@RequestBody User user) {
        kafkaTemplate.send("USER_TOPIC", user);
    }

}
