package com.clopez.sportme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.clopez.sportme.models.Deporte;
import com.clopez.sportme.models.repositories.RepoDeportes;

@RestController
// @RequestMapping("????")
public class ControladorDeportes {
    @Autowired private RepoDeportes repoDeportes;

    public List<Deporte> getAllDeportes(){
        return this.repoDeportes.getAllDeportes();
    }
    public String getDeporteById(int idDeporte){
        return this.repoDeportes.getDeporteById(idDeporte);
    }
}
