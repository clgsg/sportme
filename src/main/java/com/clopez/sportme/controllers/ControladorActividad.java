package com.clopez.sportme.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clopez.sportme.models.Actividad;
import com.clopez.sportme.models.repositories.RepoActividades;
import com.clopez.sportme.models.repositories.RepoDeportes;
import com.clopez.sportme.models.repositories.RepoInstalaciones;
import com.clopez.sportme.models.repositories.RepoUsuarios;

@Controller
@RequestMapping("/act")
public class ControladorActividad {
    
    @Autowired RepoActividades repoActividades;
    @Autowired RepoUsuarios repoUsuarios;
    @Autowired RepoInstalaciones repoInstalaciones;
    @Autowired RepoDeportes repoDeportes;

    

    @ExceptionHandler(DataAccessException.class)
    public String errorDeDatos(){
        return "common/error";
    }

    @RequestMapping("/viewall.jsp")
    public List<Actividad> getAllActividades(){
        return this.repoActividades.getAllActividades();
    }
    @RequestMapping("/search.jsp")
    public List<Actividad> getActividadesByTypeAndDate(String deporte, Timestamp fecha ){
        return this.repoActividades.getActividadesByTypeAndDate(deporte, fecha);
    }
    @RequestMapping("/search.jsp")
    public List<Actividad> getActividadesByType(String deporte){
        return this.repoActividades.getActividadesByType(deporte);
    }
    @RequestMapping("/search.jsp")
    public List<Actividad> getActividadesByDate(Timestamp fecha){
        return this.repoActividades.getActividadesByDate(fecha);
    }
    @RequestMapping("/creadas.jsp")
    public List<Actividad> getActividadesCreatedByUser(int idUsuario){
        return this.repoActividades.getActividadesCreatedByUser(idUsuario);
    }
    @RequestMapping("/inscrito.jsp")
    public List<Actividad> getActividadesWhereUsuarioParticipante(int idUsuario){
        return this.repoActividades.getActividadesWhereUsuarioParticipante(idUsuario);
    }
    @RequestMapping("/details.jsp")
    public Actividad getActividadById(int idActividad){
        return this.repoActividades.getActividadById(idActividad);
    }
    @RequestMapping("/details.jsp")
    public Integer countParticipantsByIdActividad(int idActividad){
        return this.repoActividades.countParticipantsByIdActividad(idActividad);
    }
    @RequestMapping("/nueva.jsp")
    public void createActividad(int idUsuario, int idDeporte, int idInstalacion, Timestamp fecha, String comentarios){
        this.repoActividades.createActividad(idUsuario, idDeporte, idInstalacion, fecha, comentarios);
    }
    @RequestMapping("/update.jsp")
    public void updateActividad(int idActividad, Timestamp fecha, String comentarios){
        this.repoActividades.updateActividad(idActividad, fecha, comentarios);
    }
    @RequestMapping("/remove.jsp")
    public void removeActividad(int idActividad){
        this.repoActividades.removeActividad(idActividad);
    }
}
