package com.clopez.sportme.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clopez.sportme.models.Actividad;
import com.clopez.sportme.models.repositories.RepoActividades;

@RestController
public class ControladorActividad {
    
    @Autowired private RepoActividades repoActividades;
    //@Autowired private RepoUsuarios repoUsuarios;
    //@Autowired private RepoInstalaciones repoInstalaciones;
    //@Autowired private RepoDeportes repoDeportes;

    ControladorActividad(RepoActividades repoActividades){
        this.repoActividades=repoActividades;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noEncontrado(RuntimeException e){
        return e.getMessage();
    }

    @GetMapping("/actividades")
    public List<Actividad> getAllActividades(){
        return this.repoActividades.getAllActividades();
    }
    @GetMapping("/actividades/{deporte}/{fecha}")
    public List<Actividad> getActividadesByTypeAndDate(String deporte, Timestamp fecha ){
        return this.repoActividades.getActividadesByTypeAndDate(deporte, fecha);
    }
    @GetMapping("/actividades/{deporte}")
    public List<Actividad> getActividadesByType(String deporte){
        return this.repoActividades.getActividadesByType(deporte);
    }
    @GetMapping("/actividades/{fecha}")
    public List<Actividad> getActividadesByDate(Timestamp fecha){
        return this.repoActividades.getActividadesByDate(fecha);
    }
    @GetMapping("/actividades/creadas_por_{idUsuario}")
    public List<Actividad> getActividadesCreatedByUser(int idUsuario){
        return this.repoActividades.getActividadesCreatedByUser(idUsuario);
    }
    @GetMapping("/actividades/{idUsuario}_inscrito")
    public List<Actividad> getActividadesWhereUsuarioParticipante(int idUsuario){
        return this.repoActividades.getActividadesWhereUsuarioParticipante(idUsuario);
    }
    @GetMapping("/actividades/{idActividad}")
    public Actividad getActividadById(int idActividad){
        return this.repoActividades.getActividadById(idActividad);
    }

    public Integer countParticipantsByIdActividad(int idActividad){
        return this.repoActividades.countParticipantsByIdActividad(idActividad);
    }
    @PostMapping("/actividades/nueva")
    public void createActividad(int idUsuario, int idDeporte, int idInstalacion, Timestamp fecha, String comentarios){
        this.repoActividades.createActividad(idUsuario, idDeporte, idInstalacion, fecha, comentarios);
    }
    @PutMapping("/actividades/update/{idActividad}")
    public void updateActividad(int idActividad, Timestamp fecha, String comentarios){
        this.repoActividades.updateActividad(idActividad, fecha, comentarios);
    }
    @DeleteMapping("/actividades/remove/{idActividad}")
    public void removeActividad(int idActividad){
        this.repoActividades.removeActividad(idActividad);
    }
}
