package com.pedro.medical_consult.controller;


import com.pedro.medical_consult.service.imp.ConsultServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultController {

    private ConsultServiceImpl consultService;

    public ConsultController(ConsultServiceImpl consultService) {
        this.consultService = consultService;
    }
}
