/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexis.aldana
 */
@Entity
@Table(name = "aplicador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicador.findAll", query = "SELECT a FROM Aplicador a")
    , @NamedQuery(name = "Aplicador.findById", query = "SELECT a FROM Aplicador a WHERE a.id = :id")
    , @NamedQuery(name = "Aplicador.findByNombre", query = "SELECT a FROM Aplicador a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Aplicador.findByCedulaProfesional", query = "SELECT a FROM Aplicador a WHERE a.cedulaProfesional = :cedulaProfesional")})
public class Aplicador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CEDULA_PROFESIONAL")
    private String cedulaProfesional;

    public Aplicador() {
    }

    public Aplicador(Integer id) {
        this.id = id;
    }

    public Aplicador(Integer id, String nombre, String cedulaProfesional) {
        this.id = id;
        this.nombre = nombre;
        this.cedulaProfesional = cedulaProfesional;
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

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
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
        if (!(object instanceof Aplicador)) {
            return false;
        }
        Aplicador other = (Aplicador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unam.ciencias.examenes.model.entity.Aplicador[ id=" + id + " ]";
    }
    
}
