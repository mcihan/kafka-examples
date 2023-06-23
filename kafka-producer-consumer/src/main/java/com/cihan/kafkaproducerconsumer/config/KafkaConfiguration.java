package com.cihan.kafkaproducerconsumer.config;


import com.cihan.kafkaproducerconsumer.controller.AccountSummaryMessage;
import com.cihan.kafkaproducerconsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaConfiguration {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public Map<String, Object> producerConfigs() {
        return new HashMap<>(kafkaProperties.buildProducerProperties());
    }


    @Bean
    public ProducerFactory<String, AccountSummaryMessage> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }


    @Bean
    public KafkaTemplate<String, AccountSummaryMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
