package com.curso.coches.repositorio;

import java.util.List;

import com.curso.coches.domain.Coche;



public interface CocheRepositorio {
	 List <Coche> getAllCoches();
	    Coche getCochePorMatricula(String matricula);
	    List<Coche> getCochesPorMarca(String marca);
	    Coche crearCoche(Coche coche) ;
	    Coche modificarCoche(Coche coche) ;
	    void borrarCoche(String matricula);
	  
}
