package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public void registrarVehiculo(Vehiculo v) {
		this.vehiculoRepository.insertar(v);
	}

	@Override
	public Vehiculo buscarVehiculo(String placa) {
		return this.vehiculoRepository.buscar(placa);
	}

	@Override
	public void actualizarVehiculo(Vehiculo v) {
		this.vehiculoRepository.actualizar(v);
	}

	@Override
	public void removerVehiculo(String placa) {
		this.vehiculoRepository.eliminar(placa);
	}

}
