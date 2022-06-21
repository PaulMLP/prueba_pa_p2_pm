package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.modelo.Vehiculo;

public interface IVehiculoService {

	public void registrarVehiculo(Vehiculo v);

	public Vehiculo buscarVehiculo(String placa);

	public void actualizarVehiculo(Vehiculo v);

	public void removerVehiculo(String placa);
	
	public BigDecimal calcularValor(BigDecimal precio);
}
