package com.pedro.medical_consult.controller;


import com.pedro.medical_consult.service.imp.ConsultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultController {

    @Autowired
    private ConsultServiceImpl consultService;

}
