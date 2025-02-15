package com.pedro.medical_consult.controller;


import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.service.DoctorService;
import com.pedro.medical_consult.service.imp.DoctorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.doctor.DoctorPostRequestBody;
import requests.doctor.DoctorPutRequestBody;

import java.util.List;

@RestController
@RequestMapping("doctors")

public class DoctorController {

    private final DoctorServiceImpl doctorService;


    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<Page<Doctor>> listAll (Pageable pageable) {
        return ResponseEntity.ok(doctorService.findAll(pageable));
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Doctor> findById (@PathVariable Long id){
        return ResponseEntity.ok(doctorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Doctor> save (@RequestBody @Valid DoctorPostRequestBody doctor){
        return new ResponseEntity<>(doctorService.save(doctor), HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id){
        doctorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "crm")
    public ResponseEntity<Doctor> findByCrm (@RequestParam String crm){
        return new ResponseEntity<>(doctorService.findDoctorByCrm(crm), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Doctor> replaceById (@RequestBody @Valid DoctorPutRequestBody doctorPutRequestBody){
        doctorService.replace(doctorPutRequestBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
