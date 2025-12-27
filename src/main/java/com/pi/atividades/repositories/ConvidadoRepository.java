package com.pi.atividades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.atividades.models.Convidados;
import com.pi.atividades.models.Eventos;

public interface ConvidadoRepository extends JpaRepository<Convidados, Long>{
	
	List<Convidados> findByEventos(Eventos eventos);

}
