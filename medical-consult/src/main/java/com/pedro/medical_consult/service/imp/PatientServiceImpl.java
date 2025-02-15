package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Patient;
import com.pedro.medical_consult.exception.BadRequestException;
import com.pedro.medical_consult.mapper.PatientMapper;
import com.pedro.medical_consult.repository.PatientRepository;
import com.pedro.medical_consult.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import requests.patient.PatientPostRequestBody;
import requests.patient.PatientPutRequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    @Transactional
    @Override
    public Patient save(@Valid Patient patient) {

        if (patient == null) {
            throw new EntityNotFoundException("Entity is null");
        }
        return patientRepository.save(patient) ;
    }

    @Transactional
    public Patient save (@Valid PatientPostRequestBody patientPostRequestBody) {
        if (patientPostRequestBody == null){
            throw new EntityNotFoundException("Entity is null");
        }
        System.out.println(patientPostRequestBody);

        Patient patient = patientMapper.toPatient(patientPostRequestBody);

        System.out.println(patient);

        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(Long id) {
        validateId(id);
        Patient patientOptional = patientRepository.findById(id).orElseThrow(() -> new BadRequestException("Patient not found"));

        return Optional.of(patientOptional).get();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        validateId(id);

        if (!patientRepository.existsById(id)){
            throw new BadRequestException("Entity not found");
        }
        patientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByCpf(String cpf) {
        Optional<Patient> patientOptional = findByCpf(cpf);

        if (!patientOptional.isPresent()){
            throw new BadRequestException("Entity not found");
        }

        patientRepository.deleteByCpf(cpf);

    }

    @Override
    public boolean existsById(Long id) {
       validateId(id);

      return patientRepository.existsById(id);
    }

    @Override
    public Page<Patient> findAll(Pageable pageable) {


        return patientRepository.findAll(pageable);
    }


    @Override
    public Optional<Patient> findByCpf(String cpf) {
        Patient patient = patientRepository.findByCpf(cpf).orElseThrow(() -> new BadRequestException("Patient not found"));

        return Optional.of(patient);
    }

    @Transactional
    public void replace(Patient patient) {

        Patient patientFounded = findById(patient.getIdPatient());



        patientFounded.setName(patient.getName());
        patientFounded.setCpf(patient.getCpf());
        patientFounded.setStreet(patient.getStreet());
        patientFounded.setEmail(patient.getEmail());
        patientFounded.setZipcode(patient.getZipcode());
        patientFounded.setNumberStreet(patient.getNumberStreet());
        patientFounded.setTelephone(patient.getTelephone());

        patientRepository.save(patientFounded);


    }
    @Transactional
    public void replace(PatientPutRequestBody patientPutRequestBody) {
        Patient patientSaved = findById(patientPutRequestBody.getIdPatient());

        Patient patient = patientMapper.toPatient(patientPutRequestBody);

        patient.setIdPatient(patientSaved.getIdPatient());

        patientRepository.save(patient);
    }

    @Override
    public List<Patient> findByZipcode(String zipcode) {
        List<Patient> patientsByZipcode = patientRepository.findByZipcode(zipcode);

        return patientsByZipcode.isEmpty() ? Collections.emptyList() : patientsByZipcode;
    }

    private void validateId (Long id) {
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id invalid with id: " + id);
        }
    }
}
