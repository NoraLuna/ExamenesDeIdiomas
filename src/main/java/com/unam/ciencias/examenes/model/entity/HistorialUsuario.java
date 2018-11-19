/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 
 */
@Entity
@Table(name = "historial_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialUsuario.findAll", query = "SELECT h FROM HistorialUsuario h")
    , @NamedQuery(name = "HistorialUsuario.findById", query = "SELECT h FROM HistorialUsuario h WHERE h.id = :id")
    , @NamedQuery(name = "HistorialUsuario.findByFechaAplicacion", query = "SELECT h FROM HistorialUsuario h WHERE h.fechaAplicacion = :fechaAplicacion")
    , @NamedQuery(name = "HistorialUsuario.findByIdioma", query = "SELECT h FROM HistorialUsuario h WHERE h.idioma = :idioma")
    , @NamedQuery(name = "HistorialUsuario.findByNivel", query = "SELECT h FROM HistorialUsuario h WHERE h.nivel = :nivel")
    , @NamedQuery(name = "HistorialUsuario.findByEstatusExamen", query = "SELECT h FROM HistorialUsuario h WHERE h.estatusExamen = :estatusExamen")
    , @NamedQuery(name = "HistorialUsuario.findByCalificacion", query = "SELECT h FROM HistorialUsuario h WHERE h.calificacion = :calificacion")})
public class HistorialUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA_APLICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDIOMA")
    private int idioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NIVEL")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS_EXAMEN")
    private float estatusExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFICACION")
    private float calificacion;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public HistorialUsuario() {
    }

    public HistorialUsuario(Integer id) {
        this.id = id;
    }

    public HistorialUsuario(Integer id, int idioma, String nivel, float estatusExamen, float calificacion) {
        this.id = id;
        this.idioma = idioma;
        this.nivel = nivel;
        this.estatusExamen = estatusExamen;
        this.calificacion = calificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public float getEstatusExamen() {
        return estatusExamen;
    }

    public void setEstatusExamen(float estatusExamen) {
        this.estatusExamen = estatusExamen;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof HistorialUsuario)) {
            return false;
        }
        HistorialUsuario other = (HistorialUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unam.ciencias.examenes.model.entity.HistorialUsuario[ id=" + id + " ]";
    }
    
}
