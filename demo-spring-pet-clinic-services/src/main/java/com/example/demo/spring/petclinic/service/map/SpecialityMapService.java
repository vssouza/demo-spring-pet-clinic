package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Speciality;
import com.example.demo.spring.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "Map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

    public SpecialityMapService() {
        super();
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }
}
