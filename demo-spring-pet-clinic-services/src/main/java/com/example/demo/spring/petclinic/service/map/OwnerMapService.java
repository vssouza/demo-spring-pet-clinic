package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.service.OwnerService;
import com.example.demo.spring.petclinic.service.PetService;
import com.example.demo.spring.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(final Owner entity) {
        if(entity != null && !entity.getPets().isEmpty()) {
            Owner savedOwner = super.save(entity);
            savedOwner.getPets().forEach(pet -> {
                pet.setOwner(savedOwner);
                petTypeService.save(pet.getPetType());
                petService.save(pet);
            });
            return savedOwner;
        }
        throw new IllegalArgumentException("Owner must not be null and must have at least one pet associated.");
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

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
