package com.pedro.medical_consult.repository;

import com.pedro.medical_consult.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
