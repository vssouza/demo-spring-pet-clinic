package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, I extends Long> {
    protected final  Map<Long, T> map;

    public AbstractMapService() {
        map = new HashMap<>();
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(I id) {
        return map.get(id);
    }

    public T save(T object) {
        if(object != null) {
            if(object.isNew()) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
            return object;
        }
        throw new RuntimeException("Object cannot be null.");
    }

    public void deleteById(I id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private synchronized Long getNextId() {
        try {
            return Collections.max(map.keySet()) + 1;
        } catch(NoSuchElementException ex) {
            return 1L;
        }
    }
}
