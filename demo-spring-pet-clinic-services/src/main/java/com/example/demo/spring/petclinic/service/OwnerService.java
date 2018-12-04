package com.example.demo.spring.petclinic.service;

import com.example.demo.spring.petclinic.model.Owner;

public interface OwnerService extends CRUDService<Owner, Long> {

    Owner findByLastName(String lastName);

}
