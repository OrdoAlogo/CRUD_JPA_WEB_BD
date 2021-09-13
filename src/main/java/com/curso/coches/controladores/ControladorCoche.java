package com.curso.coches.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.coches.domain.Coche;
import com.curso.coches.exception.GestionCocheException;
import com.curso.coches.services.CocheService;
@Controller
@RequestMapping("concesionario")
public class ControladorCoche {
	
	@Autowired
	private CocheService cs;
	
	@RequestMapping("/coches")
	public String coches(Model modelo) {
		modelo.addAttribute("coches", cs.getTodosCoches());
		return "index";
	}
	
	//Nueo coche
	@GetMapping("/create")
	public String create(Model modelo) {
		Coche nuevoCoche = new Coche();
		modelo.addAttribute("nuevoCoche", nuevoCoche);
		return "create";
	}
	
	//Tratar los datos para dar de alta al nuevo coche
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String procesarNuevoCoche(@ModelAttribute("nuevoCoche") @Valid Coche nuevoCoche,BindingResult br) {
		if(br.hasErrors()) {
			return "create";
		}
		cs.crearCoche(nuevoCoche);
		return "redirect:/concesionario/coches";
	}
	
	//Ver Coche
	@RequestMapping("/coche")
	public String ver(@RequestParam("matricula") String matricula,Model modelo) {
		//Coche coche = cs.getCochePorMatricula(matricula);
		modelo.addAttribute("coche", cs.getCochePorMatricula(matricula));
		return "coche";
	}
	
	//Editar 
	@GetMapping("/edit")
	public String modificar(@RequestParam("matricula") String matricula, Model modelo) {
		Coche cocheM = cs.getCochePorMatricula(matricula);
		if(cocheM == null) {
			throw new GestionCocheException(matricula, "No encontrada");
		}
		modelo.addAttribute("cocheEditado", cocheM);
		return "editar";
	}
	
	//Tratar datos del formulario de edicion
	@PostMapping(value = "/edit")
	public String tratarCocheEditado(@ModelAttribute("cocheEditado") @Valid Coche cocheEditado,BindingResult br) {
		if(br.hasErrors()) {
			return "editar";
		}
		cs.modificar(cocheEditado);
		return "redirect:/concesionario/coches";
	}
	
	@GetMapping(value = "/destroy")
	public String borrarCoche(
			@RequestParam("matricula") String matricula) {
	
		cs.borrar(matricula);
		return "redirect:/concesionario/coches"; 
	}

	
}
