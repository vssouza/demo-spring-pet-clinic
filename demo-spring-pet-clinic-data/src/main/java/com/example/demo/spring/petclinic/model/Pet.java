package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @Column(name = "birth_date")
    @Getter @Setter
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Getter @Setter
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @Getter @Setter
    private PetType petType;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    @Getter @Setter
    private Set<Visit> visits;

    public Pet() {
        visits = new HashSet<>();
    }

}
