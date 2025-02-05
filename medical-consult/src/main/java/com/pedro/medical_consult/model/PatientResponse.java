package com.pedro.medical_consult.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedro.medical_consult.domain.Patient;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("zipcode")
    private String zipcode;


    public PatientResponse(Long id, String name, String email, String cpf, String telephone, String zipcode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.telephone = telephone;
        this.zipcode = zipcode;
    }

    public static PatientResponse fromEntity (Patient patient){
        if (patient == null){
            throw new IllegalArgumentException("Patient is null");
        }

        return new PatientResponse(
                patient.getIdPatient(),
                patient.getName(),
                patient.getEmail(),
                patient.getCpf(),
                patient.getTelephone(),
                patient.getZipcode()
        );
    }


}
