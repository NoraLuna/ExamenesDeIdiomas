/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.model.repository;

import com.unam.ciencias.examenes.model.entity.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexis.aldana
 */
public interface ExamenRespository extends JpaRepository<Examen, Integer>{
    
}
