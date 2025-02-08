package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Patient;
import com.pedro.medical_consult.repository.PatientRepository;
import com.pedro.medical_consult.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Transactional
    @Override
    public Patient save(@Valid Patient patient) {

        if (patient == null) {
            throw new EntityNotFoundException("Entity is null");
        }
        return patientRepository.save(patient) ;
    }

    @Override
    public Optional<Patient> findById(Long id) {
        validateId(id);
        Patient patientOptional = patientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient not found "));

        return Optional.of(patientOptional);
    }

    @Transactional
    @Override
    public void delete(Patient patient) {
       validateId(patient.getIdPatient());

       if (!patientRepository.existsById(patient.getIdPatient())){
           throw new EntityNotFoundException("Entity not found");
       }

        patientRepository.delete(patient);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        validateId(id);

        if (!patientRepository.existsById(id)){
            throw new EntityNotFoundException("Entity not found");
        }
        patientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByCpf(String cpf) {
        Optional<Patient> patientOptional = findByCpf(cpf);

        if (!patientOptional.isPresent()){
            throw new EntityNotFoundException("Entity not found");
        }

        patientRepository.deleteByCpf(cpf);

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


    public void updateByIdPatient(Patient patient) {
        Optional<Patient> patientFounded = findById(patient.getIdPatient());

        if (!patientFounded.isPresent()){
            throw new EntityNotFoundException("Entity not found");
        }

        Patient patientWillBeUpdated = patientFounded.get();

        patientWillBeUpdated.setName(patient.getName());
        patientWillBeUpdated.setCpf(patient.getCpf());
        patientWillBeUpdated.setStreet(patient.getStreet());
        patientWillBeUpdated.setEmail(patient.getEmail());
        patientWillBeUpdated.setZipcode(patient.getZipcode());
        patientWillBeUpdated.setNumberStreet(patient.getNumberStreet());
        patientWillBeUpdated.setTelephone(patient.getTelephone());

        patientRepository.save(patientWillBeUpdated);


    }

    private void validateId (Long id) {
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id invalid with id: " + id);
        }
    }
}
