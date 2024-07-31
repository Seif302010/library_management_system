package com.lms.library_management_system.services.generic_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    @Autowired
    protected JpaRepository<T, ID> repository;

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T add(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        if (repository.existsById(id)) {
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
