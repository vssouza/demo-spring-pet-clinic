package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    @Getter @Setter
    private String address;
    @Getter @Setter
    private String city;
    @Getter @Setter
    private String telephone;
    @Getter @Setter
    private Set<Pet> pets;

    public Owner() {
        pets = new HashSet<>();
    }

}
