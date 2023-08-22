package com.example.SA2.spring.service;

import com.example.SA2.spring.model.Offer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("${topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<String, Offer> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Offer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Offer offer){
        Message<Offer> message = MessageBuilder.withPayload(offer).setHeader(KafkaHeaders.TOPIC, topicName).build();

        kafkaTemplate.send(message);

        LOGGER.info(String.format("Offer message is sent successfully to the kafka topic! -> %s", offer.toString()));
    }
}
