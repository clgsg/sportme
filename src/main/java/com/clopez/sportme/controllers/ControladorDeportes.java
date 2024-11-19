package com.clopez.sportme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clopez.sportme.models.Deporte;
import com.clopez.sportme.models.repositories.RepoDeportes;

@Controller
// @RequestMapping("????")
public class ControladorDeportes {
    @Autowired RepoDeportes repoDeportes;

    public List<Deporte> getAllDeportes(){
        return this.repoDeportes.getAllDeportes();
    }
    public String getDeporteById(int idDeporte){
        return this.repoDeportes.getDeporteById(idDeporte);
    }
}