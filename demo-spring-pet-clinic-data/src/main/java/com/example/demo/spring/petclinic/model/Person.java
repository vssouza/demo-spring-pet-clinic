package com.example.demo.spring.petclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
}
