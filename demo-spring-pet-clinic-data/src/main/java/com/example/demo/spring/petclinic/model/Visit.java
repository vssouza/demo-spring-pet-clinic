package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    @Getter @Setter
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate date;

    @Column(name = "description")
    @Getter @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @Getter @Setter
    private Pet pet;

    public Visit() {
        date = LocalDate.now();
    }
}
