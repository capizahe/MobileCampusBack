package com.college.campusmobile.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.*;

import com.college.campusmobile.model.Programa;

public interface RepositorioPrograma  extends CrudRepository<Programa,Long>{
	
	public Optional<Programa> findProgramaByNombre(String nombre);

}
