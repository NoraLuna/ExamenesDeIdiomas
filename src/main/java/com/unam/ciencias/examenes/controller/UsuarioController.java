/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.controller;

import com.unam.ciencias.examenes.model.entity.Usuario;
import com.unam.ciencias.examenes.model.repository.UsuarioRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author alexis.aldana
 */
@Scope(value = "session")
@Component(value = "usuarioController")
@ELBeanName(value = "usuarioController")
@Join(path="/usuarios", to = "/usuarios-form.jsf")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    private Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    
    private List<Usuario> usuarioList;
    
    @PostConstruct
    public void init(){
        usuarioList = usuarioRepository.findAll();
        LOG.info("Se ha cargado una lista con " + usuarioList.size() + " usuarios");        
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }
    
}
