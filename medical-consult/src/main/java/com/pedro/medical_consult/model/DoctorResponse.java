package com.pedro.medical_consult.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("crm")
    private String crm;

    @Enumerated(EnumType.STRING)
    @JsonProperty("specialization")
    private Specialization specialization;

    public DoctorResponse(Long id, String name, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public static DoctorResponse fromEntity (Doctor doctor){
        if (doctor == null){
            throw new IllegalArgumentException("Doctor is null");
        }

        return new DoctorResponse(
                doctor.getIdDoctor(),
                doctor.getName(),
                doctor.getSpecialization()
        );
    }
}
