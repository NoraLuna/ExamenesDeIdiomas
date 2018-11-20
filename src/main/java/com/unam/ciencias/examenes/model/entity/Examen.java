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
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findById", query = "SELECT e FROM Examen e WHERE e.id = :id")
    , @NamedQuery(name = "Examen.findByNivel", query = "SELECT e FROM Examen e WHERE e.nivel = :nivel")
    , @NamedQuery(name = "Examen.findBySalon", query = "SELECT e FROM Examen e WHERE e.salon = :salon")
    , @NamedQuery(name = "Examen.findByIdiomaId", query = "SELECT e FROM Examen e WHERE e.idiomaId = :idiomaId")
    , @NamedQuery(name = "Examen.findByHorarioId", query = "SELECT e FROM Examen e WHERE e.horarioId = :horarioId")
    , @NamedQuery(name = "Examen.findByAplicadorId", query = "SELECT e FROM Examen e WHERE e.aplicadorId = :aplicadorId")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NIVEL")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALON")
    private int salon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDIOMA_ID")
    private int idiomaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORARIO_ID")
    private int horarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APLICADOR_ID")
    private int aplicadorId;

    public Examen() {
    }

    public Examen(Integer id) {
        this.id = id;
    }

    public Examen(Integer id, String nivel, int salon, int idiomaId, int horarioId, int aplicadorId) {
        this.id = id;
        this.nivel = nivel;
        this.salon = salon;
        this.idiomaId = idiomaId;
        this.horarioId = horarioId;
        this.aplicadorId = aplicadorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getSalon() {
        return salon;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    public int getIdiomaId() {
        return idiomaId;
    }

    public void setIdiomaId(int idiomaId) {
        this.idiomaId = idiomaId;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public int getAplicadorId() {
        return aplicadorId;
    }

    public void setAplicadorId(int aplicadorId) {
        this.aplicadorId = aplicadorId;
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
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unam.ciencias.examenes.model.entity.Examen[ id=" + id + " ]";
    }
    
}
