package com.pedro.medical_consult.domain;

import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDoctor")
    private Long idDoctor;

    
    @Column(name = "name")
    private String name;

    
    @Column(name = "crm", unique = true)
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public String getName() {
        return name;
    }

    public String getCrm() {
        return crm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(idDoctor, doctor.idDoctor) && Objects.equals(name, doctor.name) && Objects.equals(crm, doctor.crm) && specialization == doctor.specialization;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoctor, name, crm, specialization);
    }

    public Specialization getSpecialization() {
        return specialization;


    }
}
