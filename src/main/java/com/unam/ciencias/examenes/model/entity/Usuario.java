/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.model.entity;

import com.unam.ciencias.examenes.util.EnumNivelIdioma;
import com.unam.ciencias.examenes.util.EnumTipoUsuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author alexis.aldana
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo")
    , @NamedQuery(name = "Usuario.findByNumeroCuenta", query = "SELECT u FROM Usuario u WHERE u.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByNivelActual", query = "SELECT u FROM Usuario u WHERE u.nivelActual = :nivelActual")})

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "TIPO")
    private EnumTipoUsuario tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    @Range(min = 1, max = 200)
    @Column(name = "NIVEL_ACTUAL")
    private EnumNivelIdioma nivelActual;
    @Basic(optional = true)
    @Column(name = "EXAMEN_ID")
    private Integer exmanenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "VALIDADO")
    private String validado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<HistorialUsuario> historialUsuarioList;
    @JoinColumn(name = "CONFIGURACION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ConfiguracionUsuario configuracionId;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nombre, EnumTipoUsuario tipo, String numeroCuenta, String correo, String contrasena, EnumNivelIdioma nivelActual, String validado, Integer examen) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numeroCuenta = numeroCuenta;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nivelActual = nivelActual;
        this.validado = validado;
        this.exmanenId = examen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EnumTipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public EnumNivelIdioma getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(EnumNivelIdioma nivelActual) {
        this.nivelActual = nivelActual;
    }

    @XmlTransient
    public List<HistorialUsuario> getHistorialUsuarioList() {
        return historialUsuarioList;
    }

    public void setHistorialUsuarioList(List<HistorialUsuario> historialUsuarioList) {
        this.historialUsuarioList = historialUsuarioList;
    }

    public ConfiguracionUsuario getConfiguracionId() {
        return configuracionId;
    }

    public void setConfiguracionId(ConfiguracionUsuario configuracionId) {
        this.configuracionId = configuracionId;
    }

    public String getValidado() {
        return validado;
    }

    public void setValidado(String validado) {
        this.validado = validado;
    }

    public Integer getExmanenId() {
        return exmanenId;
    }

    public void setExmanenId(Integer exmanenId) {
        this.exmanenId = exmanenId;
    }
    
    
}
