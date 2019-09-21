package com.college.campusmobile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.campusmobile.model.Materia;
import com.college.campusmobile.model.Profesor;
import com.college.campusmobile.repository.*;
import com.college.campusmobile.repository.RepositorioEstudiantes;
import com.college.campusmobile.repository.RepositorioMaterias;

@Controller
@RequestMapping(path="/materias")
public class ControladorMateria {
	
	@Autowired
	private RepositorioMaterias repositorioMateriasDao;

	@Autowired
	private RepositorioEstudiantes repositorioEstudiantesDao;
	
	@Autowired
	private RepositorioProfesores repositorioProfesoresDao;
	
	@GetMapping(path="/verMaterias")
	public @ResponseBody Iterable<Materia> verMaterias(){
		return repositorioMateriasDao.findAll();
	}
	
	@GetMapping(path="/verMateriasPorEstudiante")
	public @ResponseBody Iterable<Materia> verMaterias(@RequestParam Long id_estudiante){
	 	return repositorioEstudiantesDao.findById(id_estudiante).get().getMaterias();	
	}
	
	@PostMapping(path="/agregarMateria")
	public @ResponseBody String  agregarMateria(@RequestParam String nombre, @RequestParam Integer cant_creditos, @RequestParam Long profesor_id  ) {
		Profesor profesor = repositorioProfesoresDao.findById(profesor_id).get();
		Materia materia = new Materia(nombre, cant_creditos, profesor);
		repositorioMateriasDao.save(materia);
		return "La materia " +materia.getNombre()+" fue agregada satisfactoriamente";
	}

}
