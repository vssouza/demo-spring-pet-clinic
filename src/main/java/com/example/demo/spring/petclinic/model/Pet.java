package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Pet {

    @Getter @Setter
    private LocalDate birthDate;
    @Getter @Setter
    private Owner owner;
    @Getter @Setter
    private PetType petType;
}
