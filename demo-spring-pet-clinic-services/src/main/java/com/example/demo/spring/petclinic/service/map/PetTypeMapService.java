package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.PetType;
import com.example.demo.spring.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "Map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    public PetTypeMapService() {
        super();
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
}
