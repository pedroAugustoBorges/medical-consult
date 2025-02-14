package com.pedro.medical_consult.controller;


import com.pedro.medical_consult.domain.Patient;
import com.pedro.medical_consult.service.imp.PatientServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.patient.PatientPostRequestBody;
import requests.patient.PatientPutRequestBody;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("patients")
@Log4j2
public class PatientController {

    private final PatientServiceImpl patientService;

    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> listAll () {
//        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity <Patient> findById (@PathVariable Long id){
        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping(path = "/cpf/{cpf}")
    public ResponseEntity<Optional<Patient>> findByCpf (@PathVariable String cpf){
        return ResponseEntity.ok(patientService.findByCpf(cpf));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Patient>> findByZipcode (@RequestParam String zipcode){
        return ResponseEntity.ok(patientService.findByZipcode(zipcode));
    }

    @PostMapping
    public ResponseEntity<Patient> save (@RequestBody @Valid PatientPostRequestBody patientPostRequestBody){
        return new ResponseEntity<>(patientService.save(patientPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id) {
        patientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/cpf/{cpf}")
    public ResponseEntity<Void> deleteByCpf (@PathVariable String cpf){
        patientService.deleteByCpf(cpf);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping
    public ResponseEntity<Patient> replaceByIdPatient (@RequestBody @Valid PatientPutRequestBody patientPutRequestBody){
        patientService.replace(patientPutRequestBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
