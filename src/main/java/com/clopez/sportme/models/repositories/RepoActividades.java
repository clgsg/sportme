package com.clopez.sportme.models.repositories;

import java.security.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.Actividad;

import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;

@NamedNativeQueries({
    @NamedNativeQuery(
        name="getAllActivities",
        query ="select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a "
            + "JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE "
            + "join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
            + "and a.FECHA > SYSDATE; "
    ),
    @NamedNativeQuery(
        name="getActivitiesByTypeAndDate",
        query="select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a " 
        +  "JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE" 
        +  "join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION"
        +  "where d.deporte = :deporte and a.fecha= :fecha  "
        + "and a.FECHA > SYSDATE; "
    ),
    @NamedNativeQuery(
        name="getActivitiesByType",
        query="select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a  "
            + " JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE "
            + " join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
            + " where d.deporte = :deporte  "
            + " and a.FECHA > SYSDATE; "
    ),
    @NamedNativeQuery(
        name="getActivitiesByDate",
        query = "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a "
             + " JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE " 
             + " join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
             + "  where a.fecha= :fecha;"
    ),
    @NamedNativeQuery(
        name="getActivitiesCreatedByUser",
        query= "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a  " 
        + "JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE " 
        + "join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION " 
        + "where a.fk_usuario = :idUsuario "
        + "or a.fk_usuario= (select id_usuario from usuarios where apodo = :apodo) "
        + "and a.FECHA > SYSDATE; "
    ),
    @NamedNativeQuery(
        name="getParticipantNicks",
        query="select u.APODO from usuarios u " 
        + "join PARTICIPANTES p on p.FK_USUARIO= u.ID_USUARIO "
        + "join ACTIVIDADES a on a.ID_ACTIVIDAD = p.FK_ACTIVIDAD "
        + "where a.ID_ACTIVIDAD = :idActividad;"
    ),
    @NamedNativeQuery(
        name="countParticipantsByActivityId",
        query = "select COUNT(*)\r\n" + //
                "from usuarios u\r\n" + //
                "join PARTICIPANTES p on p.FK_USUARIO= u.ID_USUARIO\r\n" + //
                "join ACTIVIDADES a on a.ID_ACTIVIDAD = p.FK_ACTIVIDAD\r\n" + //
                "group by a.ID_ACTIVIDAD\r\n" + //
                "having a.ID_ACTIVIDAD = :idActividad;"
    ),
    @NamedNativeQuery(
        name="newActivity",
        query="INSERT INTO ACTIVIDADES "
        + " SET DEPORTE_FK"
    )
    }
)
public interface RepoActividades extends JpaRepository<Actividad, Integer> {

    Actividad getActivitiesByTypeAndDate(
        @Param("deporte") String deporte, @Param("fecha") Timestamp fecha);

    Actividad getActivitiesByType(
        @Param("deporte") String deporte);

    Actividad getActivitiesByDate(
        @Param("fecha") Timestamp fecha);
    
    Actividad getActivitiesCreatedByUser(
        @Param("idUsuario") int idUsuario, @Param("apodo") String apodo);

    Actividad getPartipantNicks(
        @Param("idActividad") int idActividad);

    Actividad countParticipantsByActivityId(
        @Param("idActividad") int idActividad);
    
}
