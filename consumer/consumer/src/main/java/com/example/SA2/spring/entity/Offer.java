package com.example.SA2.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private String product;

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", descriprion='" + description + '\'' +
                ", product='" + product + '\'' +
                '}';
    }


}
