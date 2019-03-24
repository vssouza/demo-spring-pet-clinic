package com.example.demo.spring.petclinic.repository;

import com.example.demo.spring.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
