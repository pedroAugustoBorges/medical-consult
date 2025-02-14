package com.pedro.medical_consult.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

    T save(T entity);

    T findById(ID id);

    void deleteById(ID id);

    boolean existsById(ID id);

    List<T> findAll();


}
