package com.pedro.medical_consult.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedro.medical_consult.domain.Consult;
import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.domain.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultRequest {

    @NotNull
    @JsonProperty("hour")
    private LocalTime hour;

    @NotNull
    @JsonProperty("date")
    private LocalDate date;

    @NotNull
    @JsonProperty("patient_id")
    private Patient patient;

    @NotNull
    @JsonProperty("doctor_id")
    private Doctor doctor;

    public Consult convert (Long id){
        Consult consult = new Consult();

        consult.setIdConsult(id);
        consult.setLocalTime(this.hour);
        consult.setLocalDate(this.date);
        consult.setPatient(this.patient);
        consult.setDoctor(this.doctor);

        return consult;
    }
}
