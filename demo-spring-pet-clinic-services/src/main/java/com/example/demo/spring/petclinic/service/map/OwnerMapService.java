package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Owner;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> {

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(final Owner entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Owner entity) {
        super.delete(entity);
    }
}
