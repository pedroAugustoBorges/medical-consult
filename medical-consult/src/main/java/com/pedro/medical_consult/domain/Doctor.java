package com.pedro.medical_consult.domain;

import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;

    
    @Column(name = "name")
    private String name;

    
    @Column(name = "crm", unique = true)
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

}
