package com.pedro.medical_consult.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Data
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



}
