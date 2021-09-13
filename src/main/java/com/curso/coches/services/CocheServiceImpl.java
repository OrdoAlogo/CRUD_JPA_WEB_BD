package com.curso.coches.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.coches.domain.Coche;
import com.curso.coches.exception.*;
import com.curso.coches.repositorio.CocheRepositorio;

@Service
@Transactional(propagation = Propagation.REQUIRED,
			   rollbackFor = InventarioException.class)
public class CocheServiceImpl implements CocheService {

	@Autowired
	@Qualifier("JPACocheRepositorio")
	private CocheRepositorio cocheRepositorio;
	
	
	@Override
	public List<Coche> getTodosCoches() {
		
		return cocheRepositorio.getAllCoches();
	}

	@Override
	public List<Coche> getCochesPorMarca(String marca) {
		
		return cocheRepositorio.getCochesPorMarca(marca);
	}

	@Override
	public Coche getCochePorMatricula(String matricula) {
		
		return cocheRepositorio.getCochePorMatricula(matricula);
	}

	@Override
	public Coche crearCoche(Coche coche) {
		Coche c = cocheRepositorio.getCochePorMatricula(coche.getMatricula());
		if(c != null) {
			throw new GestionCocheException(coche.getMatricula(), "No se pudo crear. el Coche ya existe");
		}
		return cocheRepositorio.crearCoche(coche);
	}

	@Override
	public Coche modificar(Coche coche) {
		// TODO Auto-generated method stub
		return cocheRepositorio.modificarCoche(coche);
	}

	@Override
	public void borrar(String matricula) {
		cocheRepositorio.borrarCoche(matricula);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,
    noRollbackFor = GestionCocheException.class )
	public void cambiarPrecio(List<Coche> coches, double nuevoPrecio) {
		for(Coche c:coches) {
			
			Coche cBD = getCochePorMatricula(c.getMatricula());
			if(cBD == null) {
				throw new GestionCocheException("No se puede modificar");
			}
			else if(cBD.getPrecio() >= nuevoPrecio) {
				
				throw new GestionCocheException("No se puede modificar");
				
			}else {
				cBD.setPrecio(nuevoPrecio);
				cocheRepositorio.modificarCoche(cBD);
			}
		}
		
	}

}
