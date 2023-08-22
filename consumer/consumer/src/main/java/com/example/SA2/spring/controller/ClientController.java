package com.example.SA2.spring.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.SA2.spring.entity.Offer;
import com.example.SA2.spring.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private final DatabaseService databaseService;

    public ClientController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    //     http://localhost:8081/client/list
    @GetMapping("/offers/getAll")
    public List<Offer> getAllOffers(){
        LOGGER.info(String.format("Request of GET all offers is received successfully!"));
        return databaseService.selectAllOffers();
    }

    //     http://localhost:8081/client/offer/${id}
    @GetMapping("/offers/{id}")
    public Offer getAnOffer(@PathVariable("id") int id){
        LOGGER.info(String.format("Request of GET an offer is received successfully!"));
        return databaseService.selectOneOffer(id);
    }
}
