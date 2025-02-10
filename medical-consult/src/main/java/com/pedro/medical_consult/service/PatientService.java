package com.pedro.medical_consult.service;

import com.pedro.medical_consult.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService extends  CrudService<Patient, Long>{

    Optional<Patient> findByCpf (String cpf);

    void deleteByCpf (String cpf);

    List<Patient> findByZipcode (String zipcode);

}
