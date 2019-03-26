package com.example.demo.spring.petclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "speciality")
@Data
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
