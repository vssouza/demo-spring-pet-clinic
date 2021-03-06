package com.example.demo.spring.petclinic.service.jpa;

import com.example.demo.spring.petclinic.model.PetType;
import com.example.demo.spring.petclinic.repository.PetTypeRepository;
import com.example.demo.spring.petclinic.service.PetTypeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
@RequiredArgsConstructor
public class PetTypeJpaService implements PetTypeService {

    @NonNull
    private final PetTypeRepository petTypeRepository;

    @Override
    public PetType findById(final Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(final PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public void delete(final PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(final Long id) {
        petTypeRepository.deleteById(id);
    }
}
