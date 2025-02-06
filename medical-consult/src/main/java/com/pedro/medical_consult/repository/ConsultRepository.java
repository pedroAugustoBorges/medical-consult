package com.pedro.medical_consult.repository;

import com.pedro.medical_consult.domain.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {


     List<Consult> findConsultByDoctorIdDoctor (Long idDoctor);

     List<Consult> findConsultByPatientIdPatient(Long idPatient);

     void deleteConsultByPatientIdPatient (Long idPatient);

     void deleteConsultByDoctorIdDoctor(Long idDoctor);

     boolean existsConsultByPatientIdPatient(Long idPatient);

     boolean existsConsultByDoctor_IdDoctor (Long idDoctor);
}
