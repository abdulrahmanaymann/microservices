package com.example.SA2.spring.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Offer {

    private long id;

    private String description;

    private String product;

    private String operationType;


    @Override
    public String toString(){
        return "Offer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", product='" + product + '\'' +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}
