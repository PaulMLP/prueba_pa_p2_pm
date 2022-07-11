package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo v) {
		this.entityManager.persist(v);
	}

	@Override
	public Vehiculo buscar(String placa) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :datoPlaca"); // JPQL
		jpqlQuery.setParameter("datoPlaca", placa);
		return (Vehiculo) jpqlQuery.getSingleResult();
	}

	@Override
	public void actualizar(Vehiculo v) {
		this.entityManager.merge(v);
	}

	@Override
	public int eliminar(String placa) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Vehiculo v WHERE v.placa = :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);
		return myQuery.executeUpdate();
	}

}
