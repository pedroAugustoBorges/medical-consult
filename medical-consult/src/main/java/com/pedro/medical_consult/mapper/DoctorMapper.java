package com.pedro.medical_consult.mapper;

import com.pedro.medical_consult.domain.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import requests.doctor.DoctorPostRequestBody;
import requests.doctor.DoctorPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class DoctorMapper {

    @Mapping( source = "crm", target = "crm")
    public abstract Doctor toDoctor (DoctorPostRequestBody doctorPostRequestBody);

    public abstract Doctor toDoctor (DoctorPutRequestBody doctorPutRequestBody);
}
