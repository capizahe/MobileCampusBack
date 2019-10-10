package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.college.campusmobile.model.Credito;
import com.college.campusmobile.model.Programa;

@Repository
public interface RepositorioCredito extends CrudRepository<Credito, Long>{

	public Optional<Credito> findCreditoByNombre(String nombre);
	
	public Iterable<Credito> findCreditoByPrograma(Programa programa);
}
