package com.pedro.medical_consult.controller;


import com.pedro.medical_consult.domain.Consult;
import com.pedro.medical_consult.service.imp.ConsultServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.consult.ConsultPostRequestBody;
import requests.consult.ConsultPutRequestBody;

@RestController
@RequestMapping(value = "consults")
public class ConsultController {

    private final ConsultServiceImpl consultService;

    public ConsultController(ConsultServiceImpl consultService) {
        this.consultService = consultService;
    }

    @PostMapping
    public ResponseEntity<Consult> save (@RequestBody ConsultPostRequestBody consultPostRequestBody){
        return ResponseEntity.ok(consultService.save(consultPostRequestBody));
    }

    @GetMapping
    public ResponseEntity<Page<Consult>> findAll (Pageable pageable){
        return new ResponseEntity<>(consultService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Consult> findById (@PathVariable Long id){
        return new ResponseEntity<>(consultService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/doctor/{id}")
    public ResponseEntity<Page<Consult> >findConsultByDoctorIdDoctor (@PathVariable Long id, Pageable pageable){
        return new ResponseEntity<>(consultService.findConsultByDoctorIdDoctor(id, pageable ), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/{id}")
    public ResponseEntity<Page<Consult> >findConsultByPatientIdPatient (@PathVariable Long id, Pageable pageable){
        return new ResponseEntity<>(consultService.findConsultByPatientIdPatient(id, pageable ), HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id){
        consultService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping (path = "/doctor/{id}")
    public ResponseEntity<Void> deleteConsultByDoctorIdDoctor (@PathVariable Long id){
        consultService.deleteConsultByDoctorIdDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping (path = "/patient/{id}")
    public ResponseEntity<Void> deleteConsultByPatientIdPatient (@PathVariable Long id){
        consultService.deleteConsultByPatientIdPatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(path = "/id/{id}" )
    public ResponseEntity<Consult> updateConsultPatch (@PathVariable Long id, @RequestBody ConsultPutRequestBody consultPutRequestBody){
        consultService.updateConsultPatch(id, consultPutRequestBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
