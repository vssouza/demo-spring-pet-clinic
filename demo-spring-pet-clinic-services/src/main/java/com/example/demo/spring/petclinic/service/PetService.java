package com.example.demo.spring.petclinic.service;

import model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();

}
