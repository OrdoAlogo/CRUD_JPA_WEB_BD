package com.curso.coches.services;

import java.util.List;

import com.curso.coches.domain.Coche;



public interface CocheService {
	 	List <Coche> getTodosCoches();
	    List<Coche> getCochesPorMarca(String marca); 
	    Coche getCochePorMatricula(String matricula);
	    Coche crearCoche(Coche coche);
	    Coche modificar(Coche coche);
	    void borrar(String matricula);
	    
	    void cambiarPrecio(List<Coche> coches, double nuevoPrecio);
}
