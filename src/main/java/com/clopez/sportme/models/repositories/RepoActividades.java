package com.clopez.sportme.models.repositories;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.Actividad;

public interface RepoActividades extends JpaRepository<Actividad, Integer> {
    List<Actividad> getAllActividades();
    List<Actividad> getActividadesByTypeAndDate(@Param("deporte") String deporte, @Param("fecha") Date fecha);
    List<Actividad> getActividadesByType(@Param("deporte") String deporte);
    List<Actividad> getActividadesByDate(@Param("fecha") Date fecha);
    List<Actividad> getActividadesCreatedByUser(@Param("idUsuario") int idUsuario);
    Actividad getActividadById(@Param("idActividad") int idActividad);

    Integer countParticipantsByIdActividad(@Param("idActividad") int idActividad);

    void createActividad(@Param("idUsuario") int idUsuario, @Param("idDeporte") int idDeporte,
            @Param("idInstalacion") int idInstalacion, @Param("fecha") Timestamp fecha,
            @Param("comentarios") String comentarios);

    void updateTimestampActividad(@Param("idActividad") int idActividad, @Param("fecha") Timestamp fecha);

    void removeActividad(@Param("idActividad") int idActividad);
}
