package com.uce.edu.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.service.IMatriculaGestorService;
import com.uce.edu.demo.service.PropietarioServiceImpl;
import com.uce.edu.demo.service.VehiculoServiceImpl;

@SpringBootApplication
public class PruebaPaP2PmApplication implements CommandLineRunner {

	@Autowired
	private PropietarioServiceImpl propietarioServiceImpl;

	@Autowired
	private VehiculoServiceImpl vehiculoServiceImpl;

	@Autowired
	private IMatriculaGestorService matriculaGestorService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaPaP2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Crear un propietario
		Propietario p = new Propietario();
		p.setNombre("Paul");
		p.setApellido("Merizalde");
		p.setCedula("1728189521");

		this.propietarioServiceImpl.crearPropietario(p);

		// Crear un vehiculo
		Vehiculo v = new Vehiculo();
		v.setMarca("Ford");
		v.setModelo("EcoSport");
		v.setPlaca("PIT012");
		v.setTipo("L");
		v.setPrecio(new BigDecimal(20000));
		this.vehiculoServiceImpl.registrarVehiculo(v);

		// Actualiar vehiculo
		v.setTipo("P");
		this.vehiculoServiceImpl.actualizarVehiculo(v);

		// Matricular vehiculo
		this.matriculaGestorService.generar(p.getCedula(), v.getPlaca());
	}

}
