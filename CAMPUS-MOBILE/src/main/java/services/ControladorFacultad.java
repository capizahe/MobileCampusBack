package services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.college.campusmobile.model.Facultad;
import com.college.campusmobile.model.Programa;
import com.college.campusmobile.model.Semillero;
import com.college.campusmobile.repository.RepositorioFacultad;
import com.college.campusmobile.repository.RepositorioPrograma;
import com.college.campusmobile.repository.RepositorioSemillero;

@RestController
@RequestMapping("/facultad")
public class ControladorFacultad {

	@Autowired
	private RepositorioFacultad repositorioFacultadDao;

	@Autowired
	private RepositorioPrograma repositorioProgramaDao;

	@Autowired
	private RepositorioSemillero repositorioSemilleroDao;

	@GetMapping(path = "/verFacultades")
	public @ResponseBody Iterable<Facultad> verFacultades() {
		return repositorioFacultadDao.findAll();
	}

	@PostMapping(path = "/agregarFacultad")
	public @ResponseBody String agregarFacultadBasico(@RequestParam String nombre) {
		if (!repositorioFacultadDao.findFacultadByNombre(nombre).isPresent()) {
			Facultad facultad = new Facultad(nombre, new ArrayList<Programa>(), new ArrayList<Semillero>());
			repositorioFacultadDao.save(facultad);
			return "La facultad " + facultad.getNombre() + " se a creado satisfactoriamente";
		}
		return "La facultad " + nombre + " ya se encuentra agregada";
	}

	@PostMapping(path = "/agregarPrograma")
	public @ResponseBody String agregarPrograma(@RequestParam String programa, @RequestParam String facultad) {
		Optional<Programa> programa_ = repositorioProgramaDao.findProgramaByNombre(programa);
		Optional<Facultad> facultad_ = repositorioFacultadDao.findFacultadByNombre(facultad);

		if (programa_.isPresent() && facultad_.isPresent()) {
			facultad_.get().getPrograma().add(programa_.get());
			repositorioFacultadDao.save(facultad_.get());
			return "El programa " + programa + " fue agregado satisfactoriamente a la facultad " + facultad;
		}
		return "Puede que el programa o la facultad no exista.";
	}

	@PostMapping(path = "/agregarSemillero")
	public @ResponseBody String agregarSemillero(@RequestParam String semillero, @RequestParam String facultad) {
		Optional<Semillero> semillero_ = repositorioSemilleroDao.findSemilleroByNombre(semillero);
		Optional<Facultad> facultad_ = repositorioFacultadDao.findFacultadByNombre(facultad);

		if (semillero_.isPresent() && facultad_.isPresent()) {
			facultad_.get().getSemilleros().add(semillero_.get());
			repositorioFacultadDao.save(facultad_.get());
			return "El semillero " + semillero + " fue agregado satisfactoriamente a la facultad " + facultad;
		}
		return "Puede que el programa o la facultad no exista.";
	}
	
}
