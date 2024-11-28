package com.clopez.sportme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clopez.sportme.models.repositories.RepoCorreos;


@RestController
public class ControladorCorreo {
    @Autowired private RepoCorreos repoCorreos;

    @GetMapping("/usr/correo")
    public String getCorreoByIdUsuario(int idUsuario){
        return this.repoCorreos.getCorreoByIdUsuario(idUsuario);
    }
    @PutMapping("/usr/correo")
    public void updateCorreoUsuario(int idUsuario, String nuevoCorreo){
        this.repoCorreos.updateCorreoUsuario( idUsuario, nuevoCorreo);
    }
}
