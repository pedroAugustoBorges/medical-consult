package com.pedro.medical_consult.mapper;


import com.pedro.medical_consult.domain.Patient;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import requests.patient.PatientPostRequestBody;
import requests.patient.PatientPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class PatientMapper {

    @Mapping(source = "numberStreet", target = "numberStreet")
    public abstract Patient toPatient (PatientPostRequestBody patientPostRequestBody);

    public abstract Patient toPatient (PatientPutRequestBody patientPutRequestBody);
}
