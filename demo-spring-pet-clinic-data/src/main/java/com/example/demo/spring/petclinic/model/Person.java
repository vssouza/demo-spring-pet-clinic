package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
class Person extends BaseEntity {

    @Column(name = "first_name")
    @Getter @Setter
    private String firstName;
    @Column(name="last_name")
    @Getter @Setter
    private String lastName;
}
