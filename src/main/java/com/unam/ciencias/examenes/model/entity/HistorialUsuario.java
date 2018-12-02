/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.model.entity;

import com.unam.ciencias.examenes.util.EnumEstatusExamen;
import com.unam.ciencias.examenes.util.EnumNivelIdioma;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexis.aldana
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
    @JoinColumn(name = "IDIOMA", referencedColumnName = "ID")
    @OneToOne
    private Idioma idioma;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NIVEL")
    private EnumNivelIdioma nivel;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "ESTATUS_EXAMEN")
    private EnumEstatusExamen estatusExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFICACION")
    private float calificacion;
    @Basic(optional = false)
    @Column(name = "USUARIO_ID")
    @NotNull
    private Integer usuarioId;

    public HistorialUsuario() {
    }

    public HistorialUsuario(Integer id) {
        this.id = id;
    }

    public HistorialUsuario(Integer id, Idioma idioma, EnumNivelIdioma nivel, EnumEstatusExamen estatusExamen, float calificacion) {
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

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public EnumNivelIdioma getNivel() {
        return nivel;
    }

    public void setNivel(EnumNivelIdioma nivel) {
        this.nivel = nivel;
    }

    public EnumEstatusExamen getEstatusExamen() {
        return estatusExamen;
    }

    public void setEstatusExamen(EnumEstatusExamen estatusExamen) {
        this.estatusExamen = estatusExamen;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
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
