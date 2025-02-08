package com.pedro.medical_consult.mapper;


import com.pedro.medical_consult.domain.Patient;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;
import requests.patient.PatientPostRequestBody;
import requests.patient.PatientPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class PatientMapper {

    public static final PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    public abstract Patient toPatient (PatientPostRequestBody patientPostRequestBody);

    public abstract Patient toPatient (PatientPutRequestBody patientPutRequestBody);
}
