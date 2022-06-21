package com.uce.edu.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
public class FachadaVehiculoImpl implements IFachadaVehiculo{

	@Autowired
	@Qualifier("pesado")
	private IVehiculoService vehiculoServiceP;
	
	@Autowired
	@Qualifier("liviano")
	private IVehiculoService vehiculoServiceL;
	
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	

	@Override
	public BigDecimal calcularValor(String placa) {
		// TODO Auto-generated method stub
		BigDecimal valor = null;
		Vehiculo v = this.vehiculoRepository.buscar(placa);
		if(v.getTipo().equals("P")) {
			//Pesado
			valor = this.vehiculoServiceP.calcularValor(v.getPrecio());
		}
		else {
			//Liviano
			valor = this.vehiculoServiceL.calcularValor(v.getPrecio());
		}
		return valor;
	}

}
