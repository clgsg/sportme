package com.clopez.sportme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clopez.sportme.models.repositories.RepoUsuarios;


@RestController
public class ControladorUsuario {
    @Autowired private RepoUsuarios repoUsuarios;

    @RequestMapping("/")
    public String redirectToHome(){
        return "redirect:/index.jsp";
    }
    

    @ExceptionHandler(DataAccessException.class)
    public String errorDeDatos(){
        return "common/error";
    }

    @GetMapping("/user/account")
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
    
    @PostMapping("/usr/new")
    public void newUsuario(String apodo, String nombre, String apellido1, String apellido2){
        this.repoUsuarios.newUsuario( apodo, nombre, apellido1, apellido2);
    }
    
    
    @DeleteMapping("/usr/remove")
    public void removeUsuario(int idUsuario){
        this.repoUsuarios.removeUsuario(idUsuario);
    }
    
}
