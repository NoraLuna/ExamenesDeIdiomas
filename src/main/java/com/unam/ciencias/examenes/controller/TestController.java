/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
@RequestMapping("examenes/idiomas/api")
public class TestController {

    private final static Logger LOG = LoggerFactory.getLogger(TestController.class);
    
    @GetMapping(value="/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity pruebaEjecucion(){
        LOG.info("Realizando prueba de ejecución");
        return new ResponseEntity("La aplicacion se está ejecutando", HttpStatus.OK);
    }
}
