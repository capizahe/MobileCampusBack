package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.college.campusmobile.model.Estudiante;
import com.college.campusmobile.model.Login;

public interface RepositorioLogin extends CrudRepository<Login,Integer>{
	
	
	public Optional<Login> findLoginByEstudiante(Estudiante estudiante);

}
