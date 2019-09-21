package com.college.campusmobile.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.campusmobile.model.Profesor;
import com.college.campusmobile.model.Semillero;
import com.college.campusmobile.repository.RepositorioProfesores;
import com.college.campusmobile.repository.RepositorioSemillero;

@Controller
@RequestMapping("/semilleros")
public class ControladorSemillero {

	@Autowired 
	private RepositorioSemillero repositorioSemilleroDao;

	@Autowired
	private RepositorioProfesores repositorioProfesoresDao;

	@GetMapping(path="/verSemilleros")
	public @ResponseBody Iterable<Semillero> verRepositorios(){
		return repositorioSemilleroDao.findAll();
	}

	@GetMapping(path="/verSemilleroPorProfesor")
	public @ResponseBody Semillero verSemilleroPorProfesor(@RequestParam Long id) {
		Optional<Profesor> profesor = repositorioProfesoresDao.findById(id);		
		if(profesor.isPresent()) {
			Optional<Semillero> semillero = repositorioSemilleroDao.findSemilleroByProfesor(profesor.get());
			if(semillero.isPresent()) {
				return semillero.get();
			}else {
				return null;
			}
		} return null;
	}
	
	@PostMapping(path="/agregarSemillero")
	public @ResponseBody String agregarSemillero(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String condicion, @RequestParam Long profesor_id, @RequestParam Boolean estado) {
		Optional<Profesor> profesor = repositorioProfesoresDao.findById(profesor_id);
		if(profesor.isPresent()) {
			Semillero semillero = new Semillero(nombre, descripcion, condicion, profesor.get(), estado);
			repositorioSemilleroDao.save(semillero);
			return "El semillero "+nombre+ " fue agregado satisfactoriamente.";
		}else return "El semillero no pudo ser agregado.";
	}

}
