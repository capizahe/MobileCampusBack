package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.college.campusmobile.model.Estudiante;

@Repository
public interface RepositorioEstudiantes  extends CrudRepository<Estudiante,Long> {

	public Optional<Estudiante> findEstudianteByUsuario(String usuario);
	
	
}
