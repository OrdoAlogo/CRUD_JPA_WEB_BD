package com.curso.coches.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.coches.domain.Coche;

@Repository
@Qualifier("JPACocheRepositorio")
@Transactional(propagation = Propagation.SUPPORTS)
public class JPACocheRepositorio implements CocheRepositorio {

	@PersistenceContext
	private EntityManager entityManager;
	
	public JPACocheRepositorio() {
		System.out.println("....Iniciando JPACocheRepositorio");
	}
	
	@Override
	public List<Coche> getAllCoches() {
		Query query = entityManager.createNamedQuery("Coche.findAll");
		return query.getResultList();
	}

	@Override
	public Coche getCochePorMatricula(String matricula) {
		
		return entityManager.find(Coche.class, matricula);
	}

	@Override
	public List<Coche> getCochesPorMarca(String marca) {
		Query query = entityManager.createNamedQuery("Coche.findByMarca");
		query.setParameter("marca", marca);
		return query.getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Coche crearCoche(Coche coche) {
		entityManager.persist(coche);
		return coche;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Coche modificarCoche(Coche coche) {
		Coche cocheBD = entityManager.find(Coche.class, coche.getMatricula());
		entityManager.merge(coche);
		return cocheBD;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void borrarCoche(String matricula) {
		Coche cocheBD = entityManager.find(Coche.class, matricula);
		entityManager.remove(cocheBD);
		
	}



}
