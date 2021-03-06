package com.example.demo.spring.petclinic.service.jpa;

import com.example.demo.spring.petclinic.model.Speciality;
import com.example.demo.spring.petclinic.repository.SpecialityRepository;
import com.example.demo.spring.petclinic.service.SpecialityService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
@RequiredArgsConstructor
public class SpecialityJpaService implements SpecialityService {

    @NonNull
    private final SpecialityRepository specialityRepository;

    @Override
    public Speciality findById(final Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(final Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public void delete(final Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(final Long id) {
        specialityRepository.deleteById(id);
    }
}
