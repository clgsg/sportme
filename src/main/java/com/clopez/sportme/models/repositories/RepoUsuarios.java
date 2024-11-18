package com.clopez.sportme.models.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.clopez.sportme.models.Actividad;
import com.clopez.sportme.models.Usuario;


public interface RepoUsuarios extends JpaRepository<Usuario, Integer> {
        Usuario getDataUsuarioById(@Param("idUsuario") int idUsuario);
        Usuario getApodoByIdUsuario(@Param("idUsuario") int idUsuario);
        Usuario getUserNameById(@Param("idUsuario") int idUsuario);
        List<Actividad> getActividadesCreatedByUsuario(@Param("idUsuario") int idUsuario);

        void newUsuario(@Param("apodo") String apodo, @Param("nombre") String nombre,
                @Param("apellido1") String apellido1, @Param("apellido2") String apellido2);

        void removeUsuario(@Param("idUsuario") int idUsuario);
    }


