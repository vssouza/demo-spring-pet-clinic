package com.example.demo.spring.petclinic.repository;

import com.example.demo.spring.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
