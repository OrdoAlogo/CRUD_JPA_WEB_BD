package com.curso.coches.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.coches.domain.Coche;
import com.curso.coches.exception.*;
import com.curso.coches.services.CocheService;

@RestController
public class CocheRestController {
	
	@Autowired
	private CocheService cocheService;
	
	//Cargar todos los Coches
	@GetMapping("rest/coches")
	public List<Coche> coches(){
		
		return cocheService.getTodosCoches();
		
	}
	
	//Obtener coche por matricula
	@GetMapping("rest/coche/{matricula}")
	public Coche coche(@PathVariable String matricula){
		Coche coche = cocheService.getCochePorMatricula(matricula);
		if(coche == null) {
			throw new GestionCocheException(matricula,"No encontrado :( ");
		}
		return coche;
	}
	
	//MODIFICAR
	@PutMapping("rest/edit/{matricula}")
	public Coche modificarCoche(@RequestBody Coche cocheModificado, @PathVariable String matricula) {
		
		Coche coche = cocheService.modificar(cocheModificado);
		return coche;
	}
	
	//PARA ELIMINAR COCHE
	@DeleteMapping("rest/destroy/{matricula}")
	public void eliminarCoche(@PathVariable String matricula) {
		cocheService.borrar(matricula);
	}

}
