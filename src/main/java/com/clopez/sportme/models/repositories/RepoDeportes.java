package com.clopez.sportme.models.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.Deporte;


public interface RepoDeportes extends JpaRepository<Deporte, Integer> {
        List<Deporte> getAllDeportes();
        Deporte getDeporteById(@Param("idDeporte") int idDeporte);
    }


