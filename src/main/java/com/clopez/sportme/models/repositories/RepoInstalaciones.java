package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.clopez.sportme.models.Instalacion;


public interface RepoInstalaciones extends JpaRepository<Instalacion, Integer> {
        Instalacion get(Long id);
        
    }


