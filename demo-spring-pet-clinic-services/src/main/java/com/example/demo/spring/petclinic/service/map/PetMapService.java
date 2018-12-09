package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Pet;
import com.example.demo.spring.petclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(final Pet entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Pet entity) {
        super.delete(entity);
    }
}
