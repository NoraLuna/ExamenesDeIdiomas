/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.service;

import com.unam.ciencias.examenes.model.entity.Usuario;
import com.unam.ciencias.examenes.model.repository.UsuarioRepository;
import com.unam.ciencias.examenes.security.PasswordService;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alexis.aldana
 */
@Named
public class LoginController implements Serializable {

    @Autowired
    PasswordService passwordService;
    @Autowired
    UsuarioRepository usuarioRepository;

    private String numeroCuenta;
    private String password;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void loginUser() {
        try {
            Usuario u = usuarioRepository.findByNumeroCuenta(numeroCuenta);
            if (u != null && u.getContrasena().equals(passwordService.encriptarPassword(password))) {
                if (Boolean.parseBoolean(u.getValidado())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.getExternalContext().getSessionMap().put("user", u);
                    ExternalContext eContext = context.getExternalContext();
                    String redirect = "";
                    eContext.redirect(eContext.getRequestContextPath() + redirect);
                } else {
                    FacesContext.getCurrentInstance().addMessage("messages",
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no está validado, ingrese en su correo y de click en el enlace de confirmaciòn.", ""));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("messages",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario y/o la contraseña son inválidos.", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("messages",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrió un error al procesar su incio de sesión, por favor intente más tarde", ""));
        }
    }

}
