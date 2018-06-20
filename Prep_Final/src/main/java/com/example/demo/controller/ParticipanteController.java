package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Participante;
import com.example.demo.service1.IParticipanteService;

@Controller
@SessionAttributes("participante")
public class ParticipanteController {

	@Autowired
	public IParticipanteService servicio;
	
	@RequestMapping(value="/crear_participante")
	public String crear(Model model) {
	Participante participante=new Participante();
	model.addAttribute("titulo", "CREAR");
	model.addAttribute("participante", participante);
	return "crear_participante";
	}
	
	@RequestMapping(value="/listar_participante",method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("participantes",servicio.findAll());
		model.addAttribute("titulo","LISTADO");
		return "listar_participante";
	}
	
	@RequestMapping(value="/crear_participante", method=RequestMethod.POST)
	public String guardar(@Valid Participante participante, Model model, RedirectAttributes flash) {
		
		servicio.save(participante);
		flash.addFlashAttribute("SUCCESS","GUARDADO");
		
		return "redirect:/listar_participante";
	}
	
}
