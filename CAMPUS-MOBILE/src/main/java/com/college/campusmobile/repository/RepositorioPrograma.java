package com.college.campusmobile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.college.campusmobile.model.Programa;

@Repository
public interface RepositorioPrograma  extends CrudRepository<Programa,Long>{
	
	public Optional<Programa> findProgramaByNombre(String nombre);

}
