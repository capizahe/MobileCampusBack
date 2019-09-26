package com.college.campusmobile.services;

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
@RequestMapping("/creditos")
public class ControladorCredito {

	@Autowired 
	private RepositorioCredito repositorioCreditoDao;

	@Autowired
	private RepositorioPrograma repositorioProgramaDao;

	@GetMapping(path = "/verCreditos")
	public @ResponseBody Iterable<Credito> verCreditos(){
		return repositorioCreditoDao.findAll();
	}

	@GetMapping(path = "/verCreditosPorPrograma")
	public @ResponseBody Iterable<Credito> verCreditosPorPrograma(@RequestParam String nombre_programa){
		Optional<Programa> programa = repositorioProgramaDao.findProgramaByNombre(nombre_programa);
		if(programa.isPresent())
			return repositorioCreditoDao.findCreditoByPrograma(programa.get());
		return null;
	}

	@PostMapping(path = "/agregarCredito")
	public @ResponseBody String agregarCredito(@RequestParam String nombre, @RequestParam Integer cantidad, @RequestParam String programa) {
		Optional<Programa> programa_ = repositorioProgramaDao.findProgramaByNombre(programa);
		if(programa_.isPresent()) {
			Credito credito = new Credito(nombre, cantidad, programa_.get());
			repositorioCreditoDao.save(credito);
			return "El credito "+credito.getNombre()+" se agrego satisfactoriamente al programa "+programa_.get().getNombre();			
		}
		return "El programa academico " + programa + "no se encuentra";
	}
    




}
