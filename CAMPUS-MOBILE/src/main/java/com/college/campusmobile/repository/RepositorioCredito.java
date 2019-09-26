package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.college.campusmobile.model.Credito;
import com.college.campusmobile.model.Programa;

public interface RepositorioCredito extends CrudRepository<Credito, Long>{

	public Optional<Credito> findCreditoByNombre(String nombre);
	
	public Iterable<Credito> findCreditoByPrograma(Programa programa);
}
