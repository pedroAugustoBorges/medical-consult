package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Consult;
import com.pedro.medical_consult.service.ConsultService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultServiceImpl implements ConsultService {

    @Override
    public Consult save(Consult entity) {
        return null;
    }

    @Override
    public Optional<Consult> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Consult entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Consult> findAll() {
        return List.of();
    }
}


