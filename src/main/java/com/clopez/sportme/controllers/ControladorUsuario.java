package com.clopez.sportme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clopez.sportme.models.repositories.RepoActividades;
import com.clopez.sportme.models.repositories.RepoUsuarios;


@Controller
@RequestMapping("/usr")
public class ControladorUsuario {
    @Autowired RepoUsuarios repoUsuarios;
    @Autowired RepoActividades repoActividades;

    @RequestMapping("/")
    public String redirectToHome(){
        return "redirect:/index.html";
    }
    

    @ExceptionHandler(DataAccessException.class)
    public String errorDeDatos(){
        return "common/error";
    }

    @RequestMapping("/account.jsp")
    public String verDatos(int idUsuario){
        this.repoUsuarios.verDatosUsuario();
        return "usr/account";
    }


}
