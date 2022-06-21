package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@Override
	public void insertar(Matricula m) {
		// TODO Auto-generated method stub
		System.out.println("Se inserto matricula "+m+" en la base de datos");
	}

	
}
