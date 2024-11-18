package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.Correo;


public interface RepoCorreos extends JpaRepository<Correo, Integer> {
        Correo getCorreoByIdUsuario(@Param("idUsuario") int idUsuario);
        void addCorreoUsuario(@Param("idUsuario") int idUsuario, @Param("correo") String correo);
        void updateCorreoUsuario(@Param("idUsuario") int idUsuario, @Param("nuevoCorreo") String nuevoCorreo);    
}


