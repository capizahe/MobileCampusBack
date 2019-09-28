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

import com.college.campusmobile.model.Credito;
import com.college.campusmobile.model.Programa;
import com.college.campusmobile.repository.RepositorioCredito;
import com.college.campusmobile.repository.RepositorioPrograma;

@Controller
@RequestMapping("/	")
public class ControladorPrograma {

	@Autowired
	private RepositorioPrograma repositorioProgramaDao;
	
	@Autowired
	private RepositorioCredito repositorioCredito;

	@GetMapping(path = "/verProgramas")
	public Iterable<Programa> verProgramas(){
		return repositorioProgramaDao.findAll();
	}

	@PostMapping(path = "/agregarPrograma")
	public @ResponseBody String agregarPrograma(@RequestParam String nombre, @RequestParam List<Credito> creditos ){
		Programa programa = new Programa(nombre,creditos);
		repositorioProgramaDao.save(programa);
		return "El programa academico "+nombre+ " fue agregado satisfactoriamente";
	}

	@PostMapping(path = "/agregarProgramaBasico")
	public @ResponseBody String agregarProgramaBasico(@RequestParam String nombre ) {
		Programa programa = new Programa(nombre, new ArrayList<Credito>());
		repositorioProgramaDao.save(programa);
		return "El programa "+nombre+ " fue agregado satisfactoriamente";
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
