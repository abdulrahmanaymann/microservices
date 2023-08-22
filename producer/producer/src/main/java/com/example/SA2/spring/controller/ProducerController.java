package com.example.SA2.spring.controller;


import com.example.SA2.spring.model.Offer;
import com.example.SA2.spring.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marketer")
public class ProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    //     http://localhost:8080/marketer/addOffer
    @PostMapping("/addOffer")
    public ResponseEntity<String> addOffer(@RequestBody Offer offer){
        offer.setOperationType("post");
        producerService.sendMessage(offer);
        LOGGER.info(String.format("Request of POST a new offer is received successfully! -> %s", offer.toString()));
        return ResponseEntity.ok("New offer is added successfully to ecommerce website! " + offer.toString());
    }

    //    http://localhost:8080/marketer/deleteOffer
    @DeleteMapping("/deleteOffer")
    public ResponseEntity<String> deleteOffer(@RequestBody Offer offer){
        offer.setOperationType("delete");
        producerService.sendMessage(offer);
        LOGGER.info(String.format("Request of DELETE an offer is received successfully! -> %s", offer.toString()));
        return ResponseEntity.ok("An offer is deleted successfully from ecommerce website! " + offer.toString());
    }

    //   http://localhost:8080/marketer/updateOffer
    @PutMapping("/updateOffer")
    public ResponseEntity<String> updateOffer(@RequestBody Offer offer){
        offer.setOperationType("update");
        producerService.sendMessage(offer);
        LOGGER.info(String.format("Request of PUT an offer is received successfully! -> %s", offer.toString()));
        return ResponseEntity.ok("An offer is updated successfully from ecommerce website! " + offer.toString());
    }
}

