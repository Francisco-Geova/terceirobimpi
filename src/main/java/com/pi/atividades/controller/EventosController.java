package com.pi.atividades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pi.atividades.models.Eventos;
import com.pi.atividades.repositories.EventosRepository;

@Controller
public class EventosController {
	
	@Autowired
	private EventosRepository er;
	
	@RequestMapping("/eventos/form")
	public String form() {
		return "eventos/FormEvento";
	}
	
	@PostMapping("/eventos")
	public String adicionar(Eventos eventos) {
		
		System.out.println(eventos);
		er.save(eventos);
		return "eventos/evento-adicionado";
	}
}