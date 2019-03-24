package com.example.demo.spring.petclinic.service.jpa;

import com.example.demo.spring.petclinic.model.Vet;
import com.example.demo.spring.petclinic.repository.VetRepository;
import com.example.demo.spring.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(final VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(final Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(final Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void delete(final Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(final Long id) {
        vetRepository.deleteById(id);
    }
}
