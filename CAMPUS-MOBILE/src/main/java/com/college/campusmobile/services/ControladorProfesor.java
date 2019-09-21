package com.college.campusmobile.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.campusmobile.model.Materia;
import com.college.campusmobile.model.Profesor;
import com.college.campusmobile.repository.RepositorioMaterias;
import com.college.campusmobile.repository.RepositorioProfesores;

@Controller
@RequestMapping(path="/profesores")
public class ControladorProfesor {

	@Autowired
	private RepositorioProfesores repositorioProfesoresDao;
	
	@Autowired
	private RepositorioMaterias repositorioMateriasDao;	
	
	@GetMapping(path="/verProfesores")
	public @ResponseBody Iterable<Profesor> verProfesores(){
		return repositorioProfesoresDao.findAll();
	}
	
	@PostMapping(path="/agregarProfesor")
	public @ResponseBody String agregarProfesor(@RequestParam Long id, @RequestParam String nombre , @RequestParam String email, @RequestParam String telefono) {
		if(!repositorioProfesoresDao.existsById(id)) {
		Profesor profesor = new Profesor(id, nombre, new ArrayList<Materia>(), email, telefono);
		repositorioProfesoresDao.save(profesor);
		
		return "El profesor "+profesor.getNombre()+" fue agregado satisfactoriamente";
		}else 
			return "El profesor "+nombre+" ya se encuentra agregado satisfactoriamente";

	}
	
	
	@PostMapping(path="/agregarMateriaProfesor")
	public @ResponseBody String agregarMateriaProfesor(@RequestParam Long id, @RequestParam Long id_materia) {
		Profesor profesor = repositorioProfesoresDao.findById(id).get();
		Materia materia = repositorioMateriasDao.findById(id_materia).get();
		repositorioProfesoresDao.delete(profesor);
		profesor.getMaterias().add(materia);
		repositorioProfesoresDao.save(profesor);
		return "La materia "+materia.getNombre()+" fue agregado satisfactoriamente para el profesor "+profesor.getNombre() ;
	}
	
	
	
	
}
