package com.clopez.sportme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.clopez.sportme.models.Instalacion;
import com.clopez.sportme.models.repositories.RepoInstalaciones;

@RestController
public class ControladorInstalaciones {
    
    @Autowired private RepoInstalaciones repoInstalaciones;

    List<Instalacion> getAllInstalaciones(){
        return this.repoInstalaciones.getAllInstalaciones();
    }

    Instalacion getDireccionInstalacionById(int idInstalacion){
        return this.repoInstalaciones.getDireccionInstalacionById(idInstalacion);
    }

    Instalacion getInfoCompletaInstalacionById(int idInstalacion){
        return this.repoInstalaciones.getInfoCompletaInstalacionById(idInstalacion);
    }

    String getTipoInstalacion(int idTipoInstalacion){
        return this.repoInstalaciones.getTipoInstalacion(idTipoInstalacion);
    }
}
