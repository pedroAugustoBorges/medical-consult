package com.pedro.medical_consult.repository;

import com.pedro.medical_consult.domain.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

   Optional<Patient> findByCpf (String cpf);

   void deleteByCpf (String cpf);

   List<Patient> findByZipcode (String zipcode);







}
