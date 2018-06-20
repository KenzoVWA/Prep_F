package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Participante;
import com.example.demo.entity.Resultado;
import com.example.demo.service1.IParticipanteService;
import com.example.demo.service1.IResultadoService;

@Controller
@SessionAttributes("resultado")
public class ResultadoController {

	@Autowired
	public IResultadoService servicio;
	
	@Autowired
	public IParticipanteService servicio2;
	
	@RequestMapping(value="/crear_resultado/{id}")
	public String crear(@PathVariable(value="id") Long id, Model model) {
		
		Participante participante=new Participante();
		participante=servicio2.findbyID(id);
		Resultado resultado=new Resultado();
		resultado.setParticipante(participante);
		
		model.addAttribute("resultado",resultado);
		model.addAttribute("titulo","CREAR");
		
		return "crear_resultado";
	}
	
	@RequestMapping(value="/crear_resultado", method=RequestMethod.POST)
	public String guardar(@Valid Resultado resultado, Model model, RedirectAttributes flash) {
		
		servicio.save(resultado);
		
		flash.addFlashAttribute("SUCCESS","AGREGADO");
		
		return "redirect:/listar_participante";
	}
	
	@RequestMapping(value="/listar_resultado_general")
	public String listar1(Model model) {
		model.addAttribute("resultados",servicio.listEspecial());
		model.addAttribute("titulo","LISTADO GENERAL");
		return "listar_resultado_general";
	}
	
	
	@RequestMapping(value="/listar_dia/{dia}")
	public String listar1(@PathVariable(value="dia") Long dia,Model model) {
		model.addAttribute("resultados",servicio.listByDia(dia));
		model.addAttribute("titulo","LISTADO GENERAL");
		return "lista_dia";
	}
	
	
}
