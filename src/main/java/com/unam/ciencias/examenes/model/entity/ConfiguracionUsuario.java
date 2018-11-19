/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 
 */
@Entity
@Table(name = "configuracion_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionUsuario.findAll", query = "SELECT c FROM ConfiguracionUsuario c")
    , @NamedQuery(name = "ConfiguracionUsuario.findById", query = "SELECT c FROM ConfiguracionUsuario c WHERE c.id = :id")
    , @NamedQuery(name = "ConfiguracionUsuario.findByDescripcion", query = "SELECT c FROM ConfiguracionUsuario c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ConfiguracionUsuario.findByHorario", query = "SELECT c FROM ConfiguracionUsuario c WHERE c.horario = :horario")
    , @NamedQuery(name = "ConfiguracionUsuario.findBySalon", query = "SELECT c FROM ConfiguracionUsuario c WHERE c.salon = :salon")
    , @NamedQuery(name = "ConfiguracionUsuario.findByIdioma", query = "SELECT c FROM ConfiguracionUsuario c WHERE c.idioma = :idioma")
    , @NamedQuery(name = "ConfiguracionUsuario.findByExamen", query = "SELECT c FROM ConfiguracionUsuario c WHERE c.examen = :examen")
    , @NamedQuery(name = "ConfiguracionUsuario.findByAplicador", query = "SELECT c FROM ConfiguracionUsuario c WHERE c.aplicador = :aplicador")
    , @NamedQuery(name = "ConfiguracionUsuario.findByGrupos", query = "SELECT c FROM ConfiguracionUsuario c WHERE c.grupos = :grupos")})
public class ConfiguracionUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORARIO")
    private short horario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALON")
    private short salon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDIOMA")
    private short idioma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXAMEN")
    private short examen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APLICADOR")
    private short aplicador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRUPOS")
    private short grupos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "configuracionId")
    private List<Usuario> usuarioList;

    public ConfiguracionUsuario() {
    }

    public ConfiguracionUsuario(Integer id) {
        this.id = id;
    }

    public ConfiguracionUsuario(Integer id, String descripcion, short horario, short salon, short idioma, short examen, short aplicador, short grupos) {
        this.id = id;
        this.descripcion = descripcion;
        this.horario = horario;
        this.salon = salon;
        this.idioma = idioma;
        this.examen = examen;
        this.aplicador = aplicador;
        this.grupos = grupos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getHorario() {
        return horario;
    }

    public void setHorario(short horario) {
        this.horario = horario;
    }

    public short getSalon() {
        return salon;
    }

    public void setSalon(short salon) {
        this.salon = salon;
    }

    public short getIdioma() {
        return idioma;
    }

    public void setIdioma(short idioma) {
        this.idioma = idioma;
    }

    public short getExamen() {
        return examen;
    }

    public void setExamen(short examen) {
        this.examen = examen;
    }

    public short getAplicador() {
        return aplicador;
    }

    public void setAplicador(short aplicador) {
        this.aplicador = aplicador;
    }

    public short getGrupos() {
        return grupos;
    }

    public void setGrupos(short grupos) {
        this.grupos = grupos;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionUsuario)) {
            return false;
        }
        ConfiguracionUsuario other = (ConfiguracionUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unam.ciencias.examenes.model.entity.ConfiguracionUsuario[ id=" + id + " ]";
    }
    
}
