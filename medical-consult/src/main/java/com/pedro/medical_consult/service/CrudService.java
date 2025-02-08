package com.pedro.medical_consult.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, Object>{

    T save (T entity);

    Optional<T> findById (Object id);

    void deleteById(Long id);

    boolean existsById (Long id);

    List<T> findAll();





}
