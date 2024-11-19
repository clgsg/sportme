package com.clopez.sportme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clopez.sportme.models.repositories.RepoCorreos;


@Controller
@RequestMapping("/usr")
public class ControladorCorreo {
    @Autowired RepoCorreos repoCorreos;

    @RequestMapping("/correo.jsp")
    public String getCorreoByIdUsuario(int idUsuario){
        return this.repoCorreos.getCorreoByIdUsuario(idUsuario);
    }
    @RequestMapping("/correo.jsp")
    public void updateCorreoUsuario(int idUsuario, String nuevoCorreo){
        this.repoCorreos.updateCorreoUsuario( idUsuario, nuevoCorreo);
    }
}
