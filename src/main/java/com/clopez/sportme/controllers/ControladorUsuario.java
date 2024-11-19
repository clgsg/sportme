package com.clopez.sportme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clopez.sportme.models.repositories.RepoUsuarios;


@Controller
@RequestMapping("/usr")
public class ControladorUsuario {
    @Autowired RepoUsuarios repoUsuarios;

    @RequestMapping("/")
    public String redirectToHome(){
        return "redirect:/index.html";
    }
    

    @ExceptionHandler(DataAccessException.class)
    public String errorDeDatos(){
        return "common/error";
    }

    @RequestMapping("/account.jsp")
    public String getDataUsuarioById(int idUsuario){
        this.repoUsuarios.getDataUsuarioById(idUsuario);
        return "usr/account";
    }
    
//    @RequestMapping("/add.jsp")
    public String getUserNameById(int idUsuario) {
        return this.repoUsuarios.getUserNameById(idUsuario);
    }

//    @RequestMapping("/add.jsp")
    public String getApodoByIdUsuario(int idUsuario) {
        return this.repoUsuarios.getApodoByIdUsuario(idUsuario);
    }
    
    @RequestMapping("/add.jsp")
    public void newUsuario(String apodo, String nombre, String apellido1, String apellido2){
        this.repoUsuarios.newUsuario( apodo, nombre, apellido1, apellido2);
    }
    
    
    @RequestMapping("/remove.jsp")
    public void removeUsuario(int idUsuario){
        this.repoUsuarios.removeUsuario(idUsuario);
    }
    
}
