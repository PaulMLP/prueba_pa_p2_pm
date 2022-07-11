package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IMatriculaRepository;
import com.uce.edu.demo.repository.IPropietarioRepository;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService {

	@Autowired
	private IPropietarioRepository propietarioRepository;

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;

	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Override
	public void generar(String cedula, String placa) {
		Propietario pro = this.propietarioRepository.buscar(cedula);
		Vehiculo vehi = this.vehiculoRepository.buscar(placa);
		String tipo = vehi.getTipo();
		BigDecimal valorMatricula;
		if (tipo.equals("P")) {
			valorMatricula = this.matriculaServicePesado.calcular(vehi.getPrecio());
		} else {
			valorMatricula = this.matriculaServiceLiviano.calcular(vehi.getPrecio());
		}
		
		if (valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal valorDescuento = valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula = valorMatricula.subtract(valorDescuento);
		}
//		Matricula matricula = new Matricula();
//		matricula.setFecha_matricula(LocalDateTime.now());
//		matricula.setPropietario(pro);
//		matricula.setVehiculo(vehi);
//		matricula.setValor_matricula(valorMatricula);
		
//		this.matriculaRepository.insertar(matricula);
	}

}
