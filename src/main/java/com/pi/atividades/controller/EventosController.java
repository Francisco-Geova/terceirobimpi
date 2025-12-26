package com.pi.atividades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pi.atividades.models.Eventos;

@Controller
public class EventosController {
	
	@RequestMapping("/eventos/form")
	public String form() {
		return "FormEvento";
	}
	
	@PostMapping("/eventos")
	public String adicionar(Eventos eventos) {
		
		System.out.println(Eventos);
		return "evento-adicionado";
	}
}
