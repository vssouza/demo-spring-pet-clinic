package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Vet;
import com.example.demo.spring.petclinic.service.SpecialityService;
import com.example.demo.spring.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(final Vet entity) {
        if(!entity.getSpecialities().isEmpty()) {
            entity.getSpecialities().forEach(speciality -> specialityService.save(speciality));
        }
        return super.save(entity);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Vet entity) {
        super.delete(entity);
    }
}
