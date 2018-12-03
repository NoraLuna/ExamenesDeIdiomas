/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.service;

import com.unam.ciencias.examenes.model.entity.Usuario;
import com.unam.ciencias.examenes.model.repository.UsuarioRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alexis.aldana
 */ 
@Named
public class HelloWorld {
    private String nombre = "Alexis";
    private String apellido = "Merlin";
    private List<Usuario> usuariosList;
    @Autowired
    UsuarioRepository usuarioRepository;
    private Usuario usuario;
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
        
    @PostConstruct
    public void vargarDatos(){
        usuariosList = usuarioRepository.findAll();
        LOG.info("Total de usuarios hallados: " + usuariosList.size());
        usuario = usuariosList.get(0);
    }
    
    public String mostrarSaludos(){
        StringBuilder saludo = new StringBuilder("Saludos ").append(nombre).append(" ").append(apellido).append("!");
        return saludo.toString();
    }
    
}
