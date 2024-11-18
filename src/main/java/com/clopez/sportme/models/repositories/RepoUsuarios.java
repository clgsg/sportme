package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.clopez.sportme.models.Usuario;


public interface RepoUsuarios extends JpaRepository<Usuario, Integer> {
        Usuario get(Long id);
        void add(Usuario usuario);
        void update(Usuario usuario);
        void remove(Usuario usuario);
    }


