package com.college.campusmobile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.college.campusmobile.model.Facultad;

@Repository
public interface RepositorioFacultad extends CrudRepository<Facultad, Integer> {

	public Optional<Facultad> findFacultadByNombre(String nombre);
}
