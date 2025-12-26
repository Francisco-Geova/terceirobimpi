package com.pi.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pi.atividades.models.Eventos;
import com.pi.atividades.repositories.EventosRepository;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventosRepository er;

	@GetMapping("/form")
	public String form() {
		return "eventos/FormEvento";
	}

	@PostMapping()
	public String adicionar(Eventos eventos) {

		System.out.println(eventos);
		er.save(eventos);
		return "eventos/evento-adicionado";
	}

	@GetMapping()
	public ModelAndView listar() {
		List<Eventos> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("Eventos", eventos);
		return mv;
	}
}