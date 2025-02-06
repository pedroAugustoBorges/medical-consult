package com.pedro.medical_consult.service;

import com.pedro.medical_consult.domain.Patient;

import java.util.Optional;

public interface PatientService extends  CrudService<Patient, Long>{

    Optional<Patient> findByCpf (String cpf);
}
