package com.example.SA2.spring.service;

import com.example.SA2.spring.entity.Offer;
import com.example.SA2.spring.entity.dto.OfferDto;
import com.example.SA2.spring.repository.OfferRepo;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;


@Service
public class DatabaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseService.class);


    private final OfferRepo offerRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public DatabaseService(OfferRepo offerRepo, ModelMapper modelMapper) {
        this.offerRepo = offerRepo;
        this.modelMapper = modelMapper;
    }


    public void insertOffer(OfferDto offerDto){
        Offer offer = modelMapper.map(offerDto, Offer.class);
        offerRepo.save(offer);

        LOGGER.info(String.format("New offer is inserted successfully in database! -> %s", offer.toString()));
    }
    public List<Offer> selectAllOffers(){
        LOGGER.info(String.format("All offers are selected successfully from database!"));
        return offerRepo.findAll();
    }

    public Offer selectOneOffer(int id){
        Optional<Offer> offerDb = offerRepo.findById(id);
        LOGGER.info(String.format("An offer is selected successfully from database! id -> %d", id));
        return offerDb.orElse(null);
    }

    public void deleteAnOffer(int id){
        LOGGER.info(String.format("An offer is deleted successfully from database! id -> %d", id));
        offerRepo.deleteById(id);
    }

    public ResponseEntity<String> updateAnOffer(OfferDto newOfferDto){
        Offer newOffer = modelMapper.map(newOfferDto, Offer.class);
        Optional<Offer> oldOffer = offerRepo.findById(newOffer.getId());

        if (oldOffer.isPresent()){
            Offer offer = oldOffer.get();

            offer.setId(newOffer.getId());

            offer.setDescription(newOffer.getDescription());

            offer.setProduct(newOffer.getProduct());

            LOGGER.info(String.format("An offer is Updated successfully in database! -> %s", offer.toString()));
            offerRepo.save(offer);
            return ResponseEntity.ok("updated is done (: ");
        }else {

            LOGGER.info(String.format("An offer is not exist in database!"));
            return ResponseEntity.ok("An offer is not exist in database! ");
        }
    }
}
