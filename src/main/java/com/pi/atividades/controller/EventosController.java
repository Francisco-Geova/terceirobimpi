package com.pi.atividades.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pi.atividades.models.Convidados;
import com.pi.atividades.models.Eventos;
import com.pi.atividades.repositories.ConvidadoRepository;
import com.pi.atividades.repositories.EventosRepository;


@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventosRepository er;
	@Autowired
	private ConvidadoRepository cr;

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

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<Eventos> opt = er.findById(id);
		if (opt.isEmpty()) {
			md.setViewName("redirect:/eventos");
			return md;
		}

		md.setViewName("eventos/detalhes");
		Eventos eventos = opt.get();
		md.addObject("eventos", eventos);
		
		List<Convidados> convidado = cr.findByEventos(eventos);
		md.addObject("convidados", convidado);
		return md;

	}

	@PostMapping("/{idEvento}")
	public String convidar(@PathVariable Long idEvento, Convidados convidado) {

		System.out.println("Id do Evento: " + idEvento);
		System.out.println(convidado);

		Optional<Eventos> opt = er.findById(idEvento);
		if (opt.isEmpty()) {
			return "redirect :/eventos";
		}
		Eventos eventos = opt.get();
		convidado.setEventos(eventos);
		cr.save(convidado);

		return "redirect:/eventos/{idEvento}";
	}
}