package com.pedro.medical_consult.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Patient")
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    
    @Column(nullable = false, name = "name")
    private String name;

    @Email
    @Column( nullable = false, unique = true, name = "email")
    private String email;

    @CPF
    @Column(nullable = false, unique = true, name = "cpf")
    private String cpf;
    
    @Column (nullable = false, name = "telephone")
    private String telephone;

    
    @Column(length = 9)
    private String zipcode;


    @Column(nullable = false, name = "number_street")
    private Long numberStreet;

    @Column(nullable = false, name = "street")
    private String street;

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public void setCpf(@CPF String cpf) {
        this.cpf = cpf;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setNumberStreet(Long numberStreet) {
        this.numberStreet = numberStreet;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public String getName() {
        return name;
    }

    public @Email String getEmail() {
        return email;
    }

    public @CPF String getCpf() {
        return cpf;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Long getNumberStreet() {
        return numberStreet;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(idPatient, patient.idPatient) && Objects.equals(name, patient.name) && Objects.equals(email, patient.email) && Objects.equals(cpf, patient.cpf) && Objects.equals(telephone, patient.telephone) && Objects.equals(zipcode, patient.zipcode) && Objects.equals(numberStreet, patient.numberStreet) && Objects.equals(street, patient.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatient, name, email, cpf, telephone, zipcode, numberStreet, street);
    }
}
