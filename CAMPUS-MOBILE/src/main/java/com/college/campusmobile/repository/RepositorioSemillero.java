package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.college.campusmobile.model.Profesor;
import com.college.campusmobile.model.Semillero;

public interface RepositorioSemillero extends CrudRepository<Semillero, Long> {
	
	public Optional<Semillero> findSemilleroByProfesor(Profesor profesor);

}
