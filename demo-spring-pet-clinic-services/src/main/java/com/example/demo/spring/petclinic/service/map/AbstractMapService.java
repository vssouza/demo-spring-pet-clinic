package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.BaseEntity;
import com.example.demo.spring.petclinic.service.CRUDService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, I> implements CRUDService<T, I> {
    protected final  Map<I, T> map;

    public AbstractMapService() {
        map = new HashMap<>();
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(I id) {
        return map.get(id);
    }

    public T save(I id, T object) {
        map.put(id, object);
        return object;
    }

    public void deleteById(I id) {
        map.remove(id);
    }

    public void delete(T object) {
        // map.entrySet().removeIf(entry -> entry.getValue().equals(object));
        map.remove(object);
    }
}
