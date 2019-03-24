package com.example.demo.spring.petclinic.repository;

import com.example.demo.spring.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
