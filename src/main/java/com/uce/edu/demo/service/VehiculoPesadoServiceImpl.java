package com.uce.edu.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Vehiculo;

@Service
@Qualifier("pesado")
public class VehiculoPesadoServiceImpl implements IVehiculoService{

	@Override
	public void registrarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehiculo buscarVehiculo(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerVehiculo(String placa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal calcularValor(BigDecimal precio) {
		// TODO Auto-generated method stub
		BigDecimal valor = precio.multiply(new BigDecimal(0.12));
		return valor;
	}

}
