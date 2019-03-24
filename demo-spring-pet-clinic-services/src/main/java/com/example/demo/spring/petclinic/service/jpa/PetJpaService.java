package com.example.demo.spring.petclinic.service.jpa;

import com.example.demo.spring.petclinic.model.Pet;
import com.example.demo.spring.petclinic.repository.PetRepository;
import com.example.demo.spring.petclinic.service.PetService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
@RequiredArgsConstructor
public class PetJpaService implements PetService {

    @NonNull
    private final PetRepository petRepository;

    @Override
    public Pet findById(final Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(final Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public void delete(final Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(final Long id) {
        petRepository.deleteById(id);
    }
}
