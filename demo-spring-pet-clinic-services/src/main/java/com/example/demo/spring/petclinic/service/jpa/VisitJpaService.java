package com.example.demo.spring.petclinic.service.jpa;

import com.example.demo.spring.petclinic.model.Visit;
import com.example.demo.spring.petclinic.repository.VisitRepository;
import com.example.demo.spring.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
public class VisitJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJpaService(final VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(final Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(final Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public void delete(final Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(final Long id) {
        visitRepository.deleteById(id);
    }
}
