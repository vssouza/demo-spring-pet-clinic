package com.example.demo.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2493833670365380258L;

    @Setter @Getter
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }
}
