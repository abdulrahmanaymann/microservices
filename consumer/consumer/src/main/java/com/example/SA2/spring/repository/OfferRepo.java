package com.example.SA2.spring.repository;

import com.example.SA2.spring.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepo extends JpaRepository<Offer,Integer> {
}
