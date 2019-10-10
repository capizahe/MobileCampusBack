package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.college.campusmobile.model.Semillero;

@Repository
public interface RepositorioSemillero extends CrudRepository<Semillero, Long> {
	
	public Optional<Semillero> findSemilleroByProfesor(String profesor);
	public Optional<Semillero> findSemilleroByNombre(String nombre);

	

}
