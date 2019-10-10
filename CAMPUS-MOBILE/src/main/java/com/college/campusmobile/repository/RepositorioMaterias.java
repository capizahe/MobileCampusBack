package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.college.campusmobile.model.Materia;

@Repository
public interface RepositorioMaterias extends CrudRepository<Materia,Long>{
	
	public Optional<Materia> findMateriaByNombre(String nombre);
	
	

}
