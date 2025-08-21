package com.ganicar.carinventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;  // If using Lombok; otherwise add getters/setters manually

@Entity
@Data  // Lombok: Generates getters, setters, toString, etc.
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private String color;
    private double price;
}