package com.example.demo.spring.petclinic.service;

import com.example.demo.spring.petclinic.model.Owner;

import java.util.Collection;

public interface OwnerService extends CRUDService<Owner, Long> {

    Collection<Owner> findByLastName(final String lastName);
    Collection<Owner> findByLastNameLike(final String lastName);

}
