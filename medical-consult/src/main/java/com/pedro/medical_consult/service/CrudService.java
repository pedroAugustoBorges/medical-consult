package com.pedro.medical_consult.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T, ID> {

    T save(T entity);

    T findById(ID id);

    void deleteById(ID id);

    boolean existsById(ID id);

    Page<T> findAll(Pageable pageable);


}
