package com.pedro.medical_consult.repository;

import com.pedro.medical_consult.domain.Consult;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {


     Page<Consult> findConsultByDoctorIdDoctor(Long idDoctor, Pageable pageable);

     Page<Consult> findConsultByPatientIdPatient(Long idPatient, Pageable pageable);

     void deleteConsultByPatientIdPatient(Long idPatient);

     void deleteConsultByDoctorIdDoctor(Long idDoctor);

     boolean existsConsultByPatientIdPatient(Long idPatient);

     boolean existsConsultByDoctor_IdDoctor(Long idDoctor);

     @Query("UPDATE Consult c SET c.patient.idPatient = :newIdPatient WHERE c.patient.idPatient = :idPatient  ")
     @Modifying
     @Transactional
     void replaceConsultByPatient(@Param("idPatient") Long idPatient, @Param("newIdPatient") Long newIdPatient);

     @Query("UPDATE Consult c SET c.doctor.idDoctor = :newIdDoctor WHERE c.doctor.idDoctor = :idDoctor  ")
     @Modifying
     @Transactional
     void replaceConsultByDoctor(@Param("idDoctor") Long idDoctor, @Param("newIdDoctor") Long newIdDoctor);

     @Query("UPDATE Consult c SET c.localTime = :newHour WHERE c.localTime = :hour ")
     @Modifying
     @Transactional
     void replaceConsultByHour (@Param("hour") String hour, @Param("newHour") String newHour);


     @Query("UPDATE Consult c SET c.localTime = :newDate WHERE c.localTime = :date ")
     @Modifying
     @Transactional
     void replaceConsultByDate(@Param("date") String date, @Param("newDate") String newDate);

}
