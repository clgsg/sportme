package com.clopez.sportme.models.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.clopez.sportme.models.Actividad;


@NoRepositoryBean
@Repository
@Component
public interface RepoActividades extends JpaRepository<Actividad, Integer> {
    List<Actividad> getAllActividades();
    List<Actividad> getActividadesByTypeAndDate(@Param("deporte") String deporte, @Param("fecha") java.sql.Timestamp fecha);
    List<Actividad> getActividadesByType(@Param("deporte") String deporte);
    List<Actividad> getActividadesByDate(@Param("fecha") Timestamp fecha);
    List<Actividad> getActividadesCreatedByUser(@Param("idUsuario") int idUsuario);
    List<Actividad> getActividadesWhereUsuarioParticipante(@Param("idUsuario") int idUsuario);
    Actividad getActividadById(@Param("idActividad") int idActividad);

    Integer countParticipantsByIdActividad(@Param("idActividad") int idActividad);

    void createActividad(@Param("idUsuario") int idUsuario, @Param("idDeporte") int idDeporte,
            @Param("idInstalacion") int idInstalacion, @Param("fecha") Timestamp fecha,
            @Param("comentarios") String comentarios);

    void updateActividad(@Param("idActividad") int idActividad, @Param("fecha") Timestamp fecha,
            @Param("comentarios") String comentarios);

    void removeActividad(@Param("idActividad") int idActividad);
}
