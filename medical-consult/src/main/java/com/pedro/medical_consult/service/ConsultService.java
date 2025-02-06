package com.pedro.medical_consult.service;

import com.pedro.medical_consult.domain.Consult;

import java.util.List;

public interface ConsultService extends CrudService<Consult, Long> {

    List<Consult> findConsultByDoctorIdDoctor (Long idDoctor);

    List<Consult> findConsultByPatientIdPatient (Long idPatient);

    void deleteConsultByDoctorIdDoctor (Long idDoctor);

    void deleteConsultByPatientIdPatient(Long idPatient);

    boolean existsConsultByDoctorIdDoctor (Long idDoctor);

    boolean existsConsultByPatientIdPatient (Long idPatient);







}
