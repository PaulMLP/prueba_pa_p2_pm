package com.uce.edu.demo.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@Override
	public void insertar(Vehiculo v) {
		// TODO Auto-generated method stub
		System.out.println("Se inserto el vehiculo: " + v+"a la base de datos");
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo v = new Vehiculo();
		v.setMarca("Ford");
		v.setModelo("EcoSport");
		v.setPlaca(placa);
		v.setPrecio(new BigDecimal(20000));
		v.setTipo("P");
		return v;
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		System.out.println("Se actualizo el vehiculo "+v);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		System.out.println("Se elimino vehiculo con placa "+placa);
	}

}
