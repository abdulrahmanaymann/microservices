package com.example.SA2.spring.service;


import com.example.SA2.spring.entity.dto.OfferDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class ConsumerService {
    private final String topicName = "${topic.name}";
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    private final ObjectMapper objectMapper;
    private final DatabaseService databaseService;

    @Autowired
    public ConsumerService(ObjectMapper objectMapper, DatabaseService databaseServices) {
        this.objectMapper = objectMapper;
        this.databaseService = databaseServices;
    }

    @KafkaListener(topics = topicName)
    public void consumeOffer(String message) throws JsonProcessingException {

        OfferDto offer = objectMapper.readValue(message, OfferDto.class);

        if(offer.getOperationType().equals("post")) {
            databaseService.insertOffer(offer);
            LOGGER.info(String.format("New offer is received successfully from the kafka topic! -> %s", offer.toString()));

        } else if (offer.getOperationType().equals("delete")) {
            databaseService.deleteAnOffer(offer.getId());
            LOGGER.info(String.format("Deleted offer is received successfully from the kafka topic! -> %s", offer.toString()));
        } else if (offer.getOperationType().equals("update")) {
            databaseService.updateAnOffer(offer);
            LOGGER.info(String.format("Updated offer is received successfully from the kafka topic! -> %s", offer.toString()));
        }
    }

}
