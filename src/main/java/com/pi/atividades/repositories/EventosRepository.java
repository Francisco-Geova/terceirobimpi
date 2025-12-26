package com.pi.atividades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.atividades.models.Eventos;

public interface EventosRepository extends JpaRepository<Eventos, Long>{

}
