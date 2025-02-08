package com.pedro.medical_consult.controller;


import com.pedro.medical_consult.domain.Patient;
import com.pedro.medical_consult.service.imp.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("patients")
public class PatientController {

    private PatientServiceImpl patientService;

    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> listAll () {
//        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<Patient>> findById (@PathVariable Long id){
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Patient> save (@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.save(patient), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Patient patient){
        patientService.delete(patient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

    @GetMapping(path = "/cpf/{cpf}")
    public ResponseEntity<Optional<Patient>> findByCpf (@PathVariable String cpf){
        return ResponseEntity.ok(patientService.findByCpf(cpf));
    }

    @PutMapping
    public ResponseEntity<Patient> updateByIdPatient (@RequestBody Patient patient){
        patientService.updateByIdPatient(patient);
        return  new ResponseEntity<>(HttpStatus.OK);
    }





}
