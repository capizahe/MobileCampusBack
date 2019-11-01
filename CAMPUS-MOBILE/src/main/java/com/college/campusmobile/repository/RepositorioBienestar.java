package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.college.campusmobile.model.Bienestar;

public interface RepositorioBienestar extends CrudRepository<Bienestar, Long> {
	
	public Iterable<Bienestar> findAllByTipo(String tipo);
	public Optional<Bienestar> findBienestarByNombre(String name);
	
	

}
