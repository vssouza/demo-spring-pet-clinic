package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Visit extends BaseEntity {

    @Getter @Setter
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate date;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Pet pet;

    public Visit() {
        date = LocalDate.now();
    }
}
