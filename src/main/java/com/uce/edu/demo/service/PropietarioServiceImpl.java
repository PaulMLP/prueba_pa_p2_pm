package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.repository.IPropietarioRepository;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository propietarioRepository;
	
	@Override
	public void crearPropietario(Propietario p) {
		this.propietarioRepository.insertar(p);
	}

	@Override
	public void eliminarPropietario(String cedula) {
		this.propietarioRepository.eliminar(cedula);
	}

}
