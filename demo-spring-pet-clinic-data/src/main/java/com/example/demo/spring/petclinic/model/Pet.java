package com.example.demo.spring.petclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
@Data
public class Pet extends BaseEntity{

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    //@MapsId
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    //@MapsId
    private PetType petType;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits;

    public Pet() {
        visits = new HashSet<>();
    }

}
