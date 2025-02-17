package com.pedro.medical_consult.domain;

import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Doctor")
    private Long idDoctor;

    
    @Column(name = "name")
    private String name;

    
    @Column(name = "crm", unique = true)
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

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

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
