package com.example.demo.spring.petclinic.service;

import model.Owner;

public interface OwnerService extends CRUDService<Owner, Long> {

    Owner findByLastName(String lastName);

}
