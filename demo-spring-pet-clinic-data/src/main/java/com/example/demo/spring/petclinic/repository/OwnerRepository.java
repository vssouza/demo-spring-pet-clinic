package com.example.demo.spring.petclinic.repository;

import com.example.demo.spring.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Collection<Owner> findByLastName(final String lastName);
    Collection<Owner> findByLastNameContainingIgnoreCase(final String lastName);
}
