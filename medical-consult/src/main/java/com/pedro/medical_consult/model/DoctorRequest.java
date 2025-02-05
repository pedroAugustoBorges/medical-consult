package com.pedro.medical_consult.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DoctorRequest {

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("crm")
    private String crm;

    @Enumerated(EnumType.STRING)
    @NotNull
    @JsonProperty("specialization")
    private Specialization specialization;

    public Doctor convert (Long id){
        Doctor doctor = new Doctor();

        doctor.setIdDoctor(id);
        doctor.setName(this.name);
        doctor.setCrm(this.crm);
        doctor.setSpecialization(this.specialization);

        return doctor;
    }

}
