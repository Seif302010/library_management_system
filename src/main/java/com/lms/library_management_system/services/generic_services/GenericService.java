package com.lms.library_management_system.services.generic_services;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {
    List<T> getAll();

    Optional<T> getById(ID id);

    T add(T entity);

    T update(ID id, T entity);

    void delete(ID id);
}
