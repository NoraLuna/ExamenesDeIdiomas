/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unam.ciencias.examenes.model.repository;

import com.unam.ciencias.examenes.model.entity.Aplicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Repository
public interface AplicadorRepository extends JpaRepository<Aplicador, Integer>{
    
}
