package com.uce.edu.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Matricula {

	private LocalDateTime fecha_matricula;
	private BigDecimal valor_matricula;
	private Propietario propietario;
	private Vehiculo vehiculo;

	@Override
	public String toString() {
		return "Matricula [fecha_matricula=" + fecha_matricula + ", valor_matricula=" + valor_matricula
				+ ", propietario=" + propietario + ", vehiculo=" + vehiculo + "]";
	}

	// SET y GET
	public LocalDateTime getFecha_matricula() {
		return fecha_matricula;
	}

	public void setFecha_matricula(LocalDateTime fecha_matricula) {
		this.fecha_matricula = fecha_matricula;
	}

	public BigDecimal getValor_matricula() {
		return valor_matricula;
	}

	public void setValor_matricula(BigDecimal valor_matricula) {
		this.valor_matricula = valor_matricula;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
