package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class PetType {

    @Getter @Setter
    private String name;
}
