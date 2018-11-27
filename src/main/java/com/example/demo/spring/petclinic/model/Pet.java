package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Pet {

    @Getter @Setter
    private LocalDate birthDate;
    @Getter @Setter
    private Owner owner;
    @Getter @Setter
    private PetType petType;
}
