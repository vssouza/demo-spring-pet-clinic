package com.example.demo.spring.petclinic.repository;

import com.example.demo.spring.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
