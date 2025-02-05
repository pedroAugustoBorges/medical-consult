package com.pedro.medical_consult.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedro.medical_consult.domain.Patient;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class PatientRequest {

    @NotNull
    @JsonProperty("name")
    private String name;

    @Email
    @NotNull
    @JsonProperty("email")
    private String email;

    @CPF
    @NotNull
    @JsonProperty("cpf")
    private String cpf;


    @NotNull
    @JsonProperty("telephone")
    private String telephone;


    @NotNull
    @JsonProperty("zipcode")
    private String zipcode;

    @NotNull
    @JsonProperty("street_name")
    private String street;

    @NotNull
    @JsonProperty("street_number")
    private Long streetNumber;



    public Patient convert (Long id){

        Patient patient = new Patient();

        patient.setIdPatient(id);
        patient.setName(this.name);
        patient.setEmail(this.email);
        patient.setCpf(this.cpf);
        patient.setZipcode(this.zipcode);
        patient.setStreet(this.street);
        patient.setNumberStreet(this.streetNumber);
        patient.setTelephone(this.telephone);

        return patient;
    }




}
