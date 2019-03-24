package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Pet;
import com.example.demo.spring.petclinic.service.PetService;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "Map"})
@NoArgsConstructor
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(final Pet entity) {
        return super.save(entity);
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
