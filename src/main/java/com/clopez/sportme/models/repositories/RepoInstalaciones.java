package com.clopez.sportme.models.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clopez.sportme.models.Instalacion;


@Repository
public interface RepoInstalaciones extends JpaRepository<Instalacion, Integer> {
        List<Instalacion> getAllInstalaciones();
        Instalacion getDireccionInstalacionById(@Param("idInstalacion") int idInstalacion);
        Instalacion getInfoCompletaInstalacionById(@Param("idInstalacion") int idInstalacion);
        
        String getTipoInstalacion(@Param("idTipoInstalacion") int idTipoInstalacion);
    
    }


