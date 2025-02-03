package com.pedro.medical_consult.repository;

import com.pedro.medical_consult.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}
