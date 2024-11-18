package com.clopez.sportme.models.repositories;

import java.security.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.Actividad;


public interface RepoActividades extends JpaRepository<Actividad, Integer> {

        Actividad get(Long id);
        void add(Actividad actividad);
        void update(Actividad actividad);
        void remove(Actividad actividad);
    }
    
