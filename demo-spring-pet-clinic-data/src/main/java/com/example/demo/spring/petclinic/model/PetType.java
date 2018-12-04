package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

public class PetType extends BaseEntity {

    @Getter @Setter
    private String name;
}
