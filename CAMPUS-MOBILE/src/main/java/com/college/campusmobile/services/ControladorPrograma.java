package com.college.campusmobile.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.campusmobile.model.*;
import com.college.campusmobile.repository.*;



@Controller
@RequestMapping("/programa")
public class ControladorPrograma {

	@Autowired
	private RepositorioPrograma repositorioProgramaDao;
	
	@Autowired
	private RepositorioCredito repositorioCredito;
	
	@Autowired
	private RepositorioFacultad repositorioFacultadDao;

	@GetMapping(path = "/verProgramas")
	public Iterable<Programa> verProgramas(){
		return repositorioProgramaDao.findAll();
	}

	@PostMapping(path = "/agregarPrograma")
	public @ResponseBody String agregarPrograma(@RequestParam String nombre, @RequestParam Facultad facultad, @RequestParam List<Credito> creditos, @RequestParam List<Materia> materias ){
		Programa programa = new Programa(nombre,facultad,creditos,materias);
		repositorioProgramaDao.save(programa);
		return "El programa academico "+nombre+ " fue agregado satisfactoriamente";
	}

	@PostMapping(path = "/agregarProgramaBasico")
	public @ResponseBody String agregarProgramaBasico(@RequestParam String nombre, @RequestParam String facultad ) {
		Optional<Facultad> facultad_ = repositorioFacultadDao.findFacultadByNombre(facultad);
		if(facultad_.isPresent()) {
		Programa programa = new Programa(nombre,facultad_.get(),new ArrayList<Credito>(),new ArrayList<Materia>());
		repositorioProgramaDao.save(programa);
		return "El programa "+nombre+ " fue agregado satisfactoriamente";
		}
		return "El programa no pudo se guardado ya que no se encuentra la facultad "+facultad; 
	}

	@GetMapping(path = "/verCreditosPorPrograma")
	public @ResponseBody Iterable<Credito> verCreditosPorPrograma(@RequestParam String nombre){
		Optional<Programa> programa = repositorioProgramaDao.findProgramaByNombre(nombre);
		if(programa.isPresent()) {
			return programa.get().getCreditos();
		} return null;
	}
	
	@PostMapping(path="/agregarCreditoPrograma")
	public @ResponseBody String agregarCreditoPrograma(@RequestParam String nombre_programa ,@RequestParam String nombre_credito){
		Optional<Programa> programa = repositorioProgramaDao.findProgramaByNombre(nombre_programa);
		Optional<Credito> credito = repositorioCredito.findCreditoByNombre(nombre_credito);
		if(programa.isPresent() && credito.isPresent()) {
			programa.get().getCreditos().add(credito.get());
			repositorioProgramaDao.save(programa.get());
			return "El credito "+credito.get().getNombre()+ " fue agregado satisfactoriamente al programa "+programa.get().getNombre();
			}
		return "No se pudo agregar el credito al programa";
	
	}


}
