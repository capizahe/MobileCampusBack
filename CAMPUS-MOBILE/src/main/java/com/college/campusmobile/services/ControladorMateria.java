package com.college.campusmobile.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.campusmobile.model.Materia;
import com.college.campusmobile.model.Programa;
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
	private RepositorioPrograma repositorioProgramaDao;
	
	
	@GetMapping(path="/verMaterias")
	public @ResponseBody Iterable<Materia> verMaterias(){
		return repositorioMateriasDao.findAll();
	}
	
	@GetMapping(path="/verMateriasPorEstudiante")
	public @ResponseBody Iterable<Materia> verMaterias(@RequestParam Long id_estudiante){
	 	return repositorioEstudiantesDao.findById(id_estudiante).get().getMaterias();	
	}
	
	@PostMapping(path="/agregarMateria")
	public @ResponseBody String  agregarMateria(@RequestParam String nombre, @RequestParam Integer cant_creditos, @RequestParam String programa) {
		Optional<Programa> programa_ = repositorioProgramaDao.findProgramaByNombre(nombre);
		if(repositorioMateriasDao.findMateriaByNombre(nombre).isPresent()) return "La materia "+nombre+ " ya se encuentra agregada";
		if(programa_.isPresent()) {
			Materia materia = new Materia(nombre,cant_creditos,programa_.get());
			repositorioMateriasDao.save(materia);
			return "La materia " +materia.getNombre()+" fue agregada satisfactoriamente";
		}
		return "La materia no se pudo agregar porque el programa "+programa+" no se encuentra";
	}

}
