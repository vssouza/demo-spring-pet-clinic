package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Visit;
import com.example.demo.spring.petclinic.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(final Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().isNew() || visit.getPet().getOwner().isNew()) {
            throw new IllegalArgumentException("Pet and pet owner must be created before a visit can be scheduled.");
        }
        return super.save(visit);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Visit visit) {
        super.delete(visit);
    }
}
