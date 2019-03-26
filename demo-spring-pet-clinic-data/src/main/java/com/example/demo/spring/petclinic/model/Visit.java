package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
@Getter
@Setter
public class Visit extends BaseEntity {

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    //@MapsId
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit() {
        date = LocalDate.now();
    }
}
