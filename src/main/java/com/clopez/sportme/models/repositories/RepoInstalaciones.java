package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.Instalacion;


public interface RepoInstalaciones extends JpaRepository<Instalacion, Integer> {
        Instalacion getAllInstalaciones();
        Instalacion getDireccionInstalacion(@Param("idInstalacion") int idInstalacion);
    }


