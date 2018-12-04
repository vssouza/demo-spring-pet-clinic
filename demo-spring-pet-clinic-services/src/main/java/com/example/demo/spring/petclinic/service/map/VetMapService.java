package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Vet;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> {

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(final Vet entity) {
        return super.save(entity.getId(), entity);
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
