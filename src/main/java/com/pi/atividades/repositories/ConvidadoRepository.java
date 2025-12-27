package com.pi.atividades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.atividades.models.Convidados;

public interface ConvidadoRepository extends JpaRepository<Convidados, Long>{

}
