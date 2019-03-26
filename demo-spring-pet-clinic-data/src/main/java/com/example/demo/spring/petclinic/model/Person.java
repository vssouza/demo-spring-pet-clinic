package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
}
