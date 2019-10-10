package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.college.campusmobile.model.Materia;

public interface RepositorioMaterias extends CrudRepository<Materia,Long>{
	
	public Optional<Materia> findMateriaByNombre(String nombre);
	
	

}
