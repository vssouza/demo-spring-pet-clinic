package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class PetType extends BaseEntity {

    @Column(name = "name")

    @Getter @Setter
    private String name;
}
