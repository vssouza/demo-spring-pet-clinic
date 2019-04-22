package com.example.demo.spring.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
public class Owner extends Person {

    @Builder
    public Owner(final Long id, final String firstName, final String lastName, final String address,
                 final String city, final String telephone, final Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets == null ? new HashSet<>() : pets;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    @Singular
    private Set<Pet> pets;

    public Pet getPet(final String petName, final boolean ignoreNew) {
        return pets.stream()
                .filter(pet ->ignoreNew || !pet.isNew())
                .filter(pet -> pet.getName().equalsIgnoreCase(petName))
                .findFirst()
                .orElse(null);
    }
}
