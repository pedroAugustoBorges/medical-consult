package com.pedro.medical_consult.controller;


import com.pedro.medical_consult.service.imp.DoctorServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    private DoctorServiceImpl doctorService;

    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }


}
