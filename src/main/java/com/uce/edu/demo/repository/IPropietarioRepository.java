package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Propietario;

public interface IPropietarioRepository {

	// Crear
	public void insertar(Propietario p);

	// Eliminar
	public void eliminar(String cedula);
	
	//Buscar
	public Propietario buscar(String cedula);
}
