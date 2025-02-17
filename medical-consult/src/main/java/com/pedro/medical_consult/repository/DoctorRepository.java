package com.pedro.medical_consult.repository;

import com.pedro.medical_consult.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT d FROM Doctor d WHERE d.crm = ?1")
    Optional<Doctor> findDoctorByCrm (String crm);






}
