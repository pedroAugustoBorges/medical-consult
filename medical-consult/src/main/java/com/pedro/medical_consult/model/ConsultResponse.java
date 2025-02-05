package com.pedro.medical_consult.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedro.medical_consult.domain.Consult;
import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.domain.Patient;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("hour")
    private LocalTime localTime;

    @JsonProperty("date")
    private LocalDate localDate;

    @JsonProperty("patient_id")
    private Patient patient;

    @JsonProperty("doctor_id")
    private Doctor doctor;

    public ConsultResponse(Long id, LocalTime localTime, LocalDate localDate, Patient patient, Doctor doctor) {
        this.id = id;
        this.localTime = localTime;
        this.localDate = localDate;
        this.patient = patient;
        this.doctor = doctor;
    }

    public static ConsultResponse fromEntity (Consult consult){
        if (consult == null){
            throw new IllegalArgumentException("Consult is null");
        }

        return new ConsultResponse(
                consult.getIdConsult(),
                consult.getLocalTime(),
                consult.getLocalDate(),
                consult.getPatient(),
                consult.getDoctor()
        );
    }
}
