/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.controller;

import com.unam.ciencias.examenes.model.entity.Examen;
import com.unam.ciencias.examenes.model.entity.Usuario;
import com.unam.ciencias.examenes.model.repository.ExamenRespository;
import com.unam.ciencias.examenes.model.repository.UsuarioRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 */
@RestController
@RequestMapping("examenes/idiomas/api")
public class TestController {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ExamenRespository examenRepository;
    
    private final static Logger LOG = LoggerFactory.getLogger(TestController.class);
    
    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity pruebaEjecucion() {
        LOG.info("Realizando prueba de ejecución");
        return new ResponseEntity("La aplicacion se está ejecutando", HttpStatus.OK);
    }
    
    @GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerTodosUsuarios() {
        LOG.info("Se obtendrá la lista de todos los usuarios");
        List<Usuario> findAll = usuarioRepository.findAll();
        return new ResponseEntity(findAll, HttpStatus.OK);
    }
    
    @PostMapping(value = "/usuarios", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> agregarUsuario(Usuario usuario) {
        LOG.info("Se agregará un nuevo usaurio así por mis huevos");
        Usuario usuarioGuardado = usuarioRepository.saveAndFlush(usuario);
        LOG.info("Se ha almacenado el usaurio con los siguientes datos:");
        LOG.info("ID: " + usuarioGuardado.getId());
        LOG.info("Nombre: " + usuarioGuardado.getNombre());
        LOG.info("Nombre: " + usuarioGuardado.getNivelActual().name());        
        return new ResponseEntity("Se procesado correctamen la petición", HttpStatus.OK);
    }
    
    @GetMapping(value = "/examenes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerTodosExamenes() {
        LOG.info("Se obtendrán todos los exámenes registrados");
        return new ResponseEntity(examenRepository.findAll(), HttpStatus.OK);
    }
    
    @PostMapping(value = "/examenes", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity agregarNuevoExamen(Examen examen) {
        LOG.info("Se procederá a agregar un nuevo examen a la base de datos");
        Examen examenGuardado = examenRepository.saveAndFlush(examen);
        LOG.info("Se ha alamacenado el registro con los siguientes datos");
        LOG.info("Id: " + examenGuardado.getId());
        return new ResponseEntity("Se ha recibido la petición correctamente", HttpStatus.OK);
    }
}
