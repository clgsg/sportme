package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.TipoInstalacion;


public interface RepoTipoInstalaciones extends JpaRepository<TipoInstalacion, Integer> {
        TipoInstalacion getAllTipos();
        TipoInstalacion getTipoInstalacion(@Param("idTipoInstalacion") int idTipoInstalacion);
    }


