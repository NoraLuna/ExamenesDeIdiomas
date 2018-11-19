/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.model.repository;

import com.unam.ciencias.examenes.model.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexis.aldana
 */
public interface GrupoRespository extends JpaRepository<Grupo, Integer>{
    
}
