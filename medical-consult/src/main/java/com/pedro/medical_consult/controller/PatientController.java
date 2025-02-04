package com.pedro.medical_consult.controller;


import com.pedro.medical_consult.domain.Patient;
import com.pedro.medical_consult.service.imp.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private PatientServiceImpl patientService;

    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }




}
