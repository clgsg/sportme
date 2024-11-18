package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.clopez.sportme.models.Deporte;


public interface RepoDeportes extends JpaRepository<Deporte, Integer> {
        Deporte get(Long id);
        
    }


