package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.clopez.sportme.models.Correo;


public interface RepoCorreos extends JpaRepository<Correo, Integer> {
        Correo get(Long id);
        void add(Correo correo);
        void update(Correo correo);
    }


