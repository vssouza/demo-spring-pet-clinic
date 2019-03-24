package com.example.demo.spring.petclinic.repository;

import com.example.demo.spring.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
