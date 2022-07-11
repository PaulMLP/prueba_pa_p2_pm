package com.uce.edu.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "matricula")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Matricula {

	@Id
	@Column(name = "matr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matr_seq_id")
	@SequenceGenerator(name="matr_id",sequenceName="matr_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "matr_fecha_matricula")
	private LocalDateTime fecha_matricula;
	
	@Column(name = "matr_valor_matricula")
	private BigDecimal valor_matricula;
//	
//	@Column(name = "matr_propietario")
//	private Propietario propietario;
//	
//	@Column(name = "matr_vehiculo")
//	private Vehiculo vehiculo;

//	@Override
//	public String toString() {
//		return "Matricula [id=" + id + ", fecha_matricula=" + fecha_matricula + ", valor_matricula=" + valor_matricula
//				+ ", propietario=" + propietario + ", vehiculo=" + vehiculo + "]";
//	}

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

//	public Propietario getPropietario() {
//		return propietario;
//	}
//
//	public void setPropietario(Propietario propietario) {
//		this.propietario = propietario;
//	}
//
//	public Vehiculo getVehiculo() {
//		return vehiculo;
//	}
//
//	public void setVehiculo(Vehiculo vehiculo) {
//		this.vehiculo = vehiculo;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
