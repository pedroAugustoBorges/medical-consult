package com.pedro.medical_consult.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


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

    
    @Column (nullable = false, name = "telephone")
    private String telephone;

    
    @Column(length = 9)
    private String zipcode;

    
    private String numberStreet;

    
    private String street;



}
