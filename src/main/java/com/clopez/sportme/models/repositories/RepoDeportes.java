package com.clopez.sportme.models.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clopez.sportme.models.Deporte;

@Repository
public interface RepoDeportes extends JpaRepository<Deporte, Integer> {
        List<Deporte> getAllDeportes();
        String getDeporteById(@Param("idDeporte") int idDeporte);
    }


