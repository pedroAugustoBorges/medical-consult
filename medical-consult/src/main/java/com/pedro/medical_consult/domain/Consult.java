package com.pedro.medical_consult.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consult")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsult;

    @Column(name = "date")
    private LocalDate localDate;

    @Column(name = "hour")
    private LocalTime localTime;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "idPatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "idDoctor")
    private Doctor doctor;

    public void setIdConsult(Long idConsult) {
        this.idConsult = idConsult;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getIdConsult() {
        return idConsult;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consult consult = (Consult) o;
        return Objects.equals(idConsult, consult.idConsult) && Objects.equals(localDate, consult.localDate) && Objects.equals(localTime, consult.localTime) && Objects.equals(patient, consult.patient) && Objects.equals(doctor, consult.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConsult, localDate, localTime, patient, doctor);
    }
}
