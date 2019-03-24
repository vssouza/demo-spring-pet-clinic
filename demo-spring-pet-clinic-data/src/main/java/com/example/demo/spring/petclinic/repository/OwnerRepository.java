package com.example.demo.spring.petclinic.repository;

import com.example.demo.spring.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    public Owner findByLastName(final String lastName);
}
