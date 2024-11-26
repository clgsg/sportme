package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clopez.sportme.models.Correo;

@Repository
public interface RepoCorreos extends JpaRepository<Correo, Integer> {
        String getCorreoByIdUsuario(@Param("idUsuario") int idUsuario);
        
        void updateCorreoUsuario(@Param("idUsuario") int idUsuario, @Param("nuevoCorreo") String nuevoCorreo);
}


