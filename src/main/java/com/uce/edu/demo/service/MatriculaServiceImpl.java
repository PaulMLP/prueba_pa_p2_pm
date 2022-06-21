package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.repository.IMatriculaRepository;
import com.uce.edu.demo.repository.PropietarioRepositoryImpl;
import com.uce.edu.demo.repository.VehiculoRepositoryImpl;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private PropietarioRepositoryImpl propietarioRepository;

	@Autowired
	private VehiculoRepositoryImpl vehiculoRepository;

	@Autowired
	private FachadaVehiculoImpl fachadaVehiculoImpl;

	@Autowired
	private IMatriculaRepository matriculaRepository;

	@Override
	public void crearMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		Matricula m = new Matricula();
		BigDecimal valor = this.fachadaVehiculoImpl.calcularValor(placa);
		m.setFecha_matricula(LocalDateTime.now());
		m.setPropietario(this.propietarioRepository.buscar(cedula));
		m.setVehiculo(this.vehiculoRepository.buscar(placa));

		if (valor.compareTo(new BigDecimal(2000)) == 1) {
			valor = valor.add(valor.multiply(new BigDecimal(0.07)));
		}
		m.setValor_matricula(valor);
		
		this.matriculaRepository.insertar(m);
	}

}
