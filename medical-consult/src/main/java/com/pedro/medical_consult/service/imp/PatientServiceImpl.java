package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Patient;
import com.pedro.medical_consult.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Override
    public Patient save(Patient entity) {
        return null;
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Patient entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Patient> findAll() {
        return List.of();
    }
}
