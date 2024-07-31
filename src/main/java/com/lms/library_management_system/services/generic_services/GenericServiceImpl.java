package com.lms.library_management_system.services.generic_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import com.lms.library_management_system.exceptions.ErrorMessage;
import com.lms.library_management_system.helpers.ObjectMapper;

public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    @Autowired
    protected JpaRepository<T, ID> repository;

    protected void checkIdExistance(ID id) {
        if (!repository.existsById(id)) {
            throw new ErrorMessage("Entity not found with id: " + id);
        }
    }

    protected void validatePost(T entity) {
    }

    protected void validatePut(T entity) {
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        checkIdExistance(id);
        return repository.findById(id);
    }

    @Override
    public T add(T entity) {
        validatePost(entity);
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        validatePut(entity);
        T existingEntity = repository.findById(id)
                .orElseThrow(() -> new ErrorMessage("Entity not found with id: " + id));
        ObjectMapper.mapNonNullAndNonEmptyValues(entity, existingEntity);
        return repository.save(existingEntity);
    }

    @Override
    public void delete(ID id) {
        checkIdExistance(id);
        repository.deleteById(id);
    }
}
