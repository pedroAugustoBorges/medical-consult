package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Patient;
import com.pedro.medical_consult.repository.PatientRepository;
import com.pedro.medical_consult.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public Patient save(@Valid Patient patient) {

        if (patient == null) {
            throw new EntityNotFoundException("Entity is null");
        }
        return patientRepository.save(patient) ;
    }

    @Override
    public Optional<Patient> findById(Long id) {
        Patient patientOptional = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found "));

        return Optional.of(patientOptional);
    }

    @Override
    public void delete(Patient patient) {
       validateId(patient.getIdPatient());

       if (!patientRepository.existsById(patient.getIdPatient())){
           throw new EntityNotFoundException("Entity not found");
       }

        patientRepository.delete(patient);
    }

    @Override
    public void deleteById(Long id) {
        validateId(id);

        if (!patientRepository.existsById(id)){
            throw new EntityNotFoundException("Entity not found");
        }
        patientRepository.deleteById(id);
    }


    @Override
    public boolean existsById(Long id) {
       validateId(id);

      return patientRepository.existsById(id);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = patientRepository.findAll();

        return patients.isEmpty() ? Collections.emptyList() : patients;
    }

    @Override
    public Optional<Patient> findByCpf(String cpf) {
        Patient patient = patientRepository.findByCpf(cpf).orElseThrow(() -> new IllegalArgumentException("Patint with cpf: " + cpf + " not found"));

        return Optional.of(patient);
    }

    private void validateId (Long id) {
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id invalid with id: " + id);
        }
    }
}
