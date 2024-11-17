package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.Usuario;

import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;


@NamedNativeQueries({
    @NamedNativeQuery(
        name="getApodoById",
        query ="SELECT apodo from USUARIOS where ID_USUARIO= :idUsuario;"
    ),
    @NamedNativeQuery(
        name="getUserFirstNameById",
        query="select u.nombre from USUARIOS u "
        + " where u.ID_USUARIO= :idUsuario; "
    ),
    @NamedNativeQuery(
        name="getUsersByType",
        query="select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a  "
            + " JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE "
            + " join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
            + " where d.deporte = :deporte  "
            + " and a.FECHA > SYSDATE; "
    ),
    @NamedNativeQuery(
        name="getMailByApodo",
        query = "select c.correo from CORREOS c "
            + " where c.FK_USUARIO = (select id_usuario from USUARIOS where apodo= LOWER(:apodo)); "
    ),
    @NamedNativeQuery(
        name="getMailById",
        query = "select c.correo from CORREOS c "
            + " where c.FK_USUARIO = :id; "
    ),
    @NamedNativeQuery(
        name="getUsersCreatedByUser",
        query= "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a  " 
        + "JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE " 
        + "join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION " 
        + "where a.fk_usuario = :idUsuario "
        + "or a.fk_usuario= (select id_usuario from usuarios where apodo = :apodo) "
        + "and a.FECHA > SYSDATE; "
    )
    }
)
public interface RepoUsuarios extends JpaRepository<Usuario, Integer> {
    Usuario getApodoById(
        @Param("idUsuario") int idUsuario);
        
    Usuario getUserFirstNameById(
        @Param("idUsuario") int idUsuario);
    
    Usuario getMailByApodo(
        @Param("apodo") String apodo);
    
    Usuario getMailById(
        @Param("idUsuario") int idUsuario);
    
    Usuario getUsersCreatedByUser(
        @Param("idUsuario") int idUsuario, @Param("apodo") String apodo);

    void verDatosUsuario();

    void updateCorreo();
    
}


