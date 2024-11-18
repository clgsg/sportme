package com.clopez.sportme.models.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.clopez.sportme.models.TipoInstalacion;


public interface RepoTipoInstalaciones extends JpaRepository<TipoInstalacion, Integer> {
        TipoInstalacion get(Long id);
    }


