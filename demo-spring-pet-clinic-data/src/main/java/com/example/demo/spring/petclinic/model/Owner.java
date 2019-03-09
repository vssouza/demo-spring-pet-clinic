package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    @Getter @Setter
    private String address;

    @Column(name = "city")
    @Getter @Setter
    private String city;

    @Column(name = "telephone")
    @Getter @Setter
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @Getter @Setter
    private Set<Pet> pets;

    public Owner() {
        pets = new HashSet<>();
    }

}
