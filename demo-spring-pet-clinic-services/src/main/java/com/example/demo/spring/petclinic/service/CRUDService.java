package com.example.demo.spring.petclinic.service;

import com.example.demo.spring.petclinic.model.BaseEntity;

import java.util.Set;

public interface CRUDService<T extends BaseEntity, I> {
    T findById(I id);
    T save(T entity);
    Set<T> findAll();
    void delete(T entity);
    void deleteById(I id);
}
