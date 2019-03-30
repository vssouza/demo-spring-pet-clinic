package com.example.demo.spring.petclinic.service.jpa;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.repository.OwnerRepository;
import com.example.demo.spring.petclinic.service.OwnerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
@RequiredArgsConstructor
public class OwnerJpaService implements OwnerService {

    @NonNull
    private final OwnerRepository ownerRepository;

    @Override
    public Owner findByLastName(final String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(final Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(final Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public void delete(final Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(final Long id) {
        ownerRepository.deleteById(id);
    }
}
