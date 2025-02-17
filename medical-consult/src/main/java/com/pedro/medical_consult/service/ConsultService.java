package com.pedro.medical_consult.service;

import com.pedro.medical_consult.domain.Consult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import requests.consult.ConsultPutRequestBody;

import java.util.List;
import java.util.Optional;

public interface ConsultService extends CrudService<Consult, Long> {

    Page<Consult> findConsultByDoctorIdDoctor (Long idDoctor, Pageable pageable);

    Page<Consult> findConsultByPatientIdPatient (Long idPatien, Pageable pageablet);

    void deleteConsultByDoctorIdDoctor (Long idDoctor);

    void deleteConsultByPatientIdPatient(Long idPatient);

    boolean existsConsultByDoctorIdDoctor (Long idDoctor);

    boolean existsConsultByPatientIdPatient (Long idPatient);

   Consult updateConsultPatch (Long id, ConsultPutRequestBody consultPutRequestBody);







}
