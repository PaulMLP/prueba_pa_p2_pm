package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Propietario;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Propietario p) {
		this.entityManager.persist(p);
	}

	@Override
	public int eliminar(String cedula) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Propietario p WHERE p.cedula = :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

	@Override
	public Propietario buscar(String cedula) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula = :datoCedula"); // JPQL
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Propietario) jpqlQuery.getSingleResult();
	}

}
