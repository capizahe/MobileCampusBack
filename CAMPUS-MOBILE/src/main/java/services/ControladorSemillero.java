package services;

import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.campusmobile.model.Semillero;
import com.college.campusmobile.repository.RepositorioSemillero;

@RestController
@RequestMapping("/semilleros")
public class ControladorSemillero {

	@Autowired
	private RepositorioSemillero repositorioSemilleroDao;

	@GetMapping(path = "/verSemilleros")
	public @ResponseBody Iterable<Semillero> verRepositorios() {
		return repositorioSemilleroDao.findAll();
	}

	@GetMapping(path = "/verSemilleroPorProfesor")
	public @ResponseBody Semillero verSemilleroPorProfesor(@RequestParam String profesor) {
		Optional<Semillero> semillero = repositorioSemilleroDao.findSemilleroByProfesor(profesor);
		if (semillero.isPresent())
			return semillero.get();
		return null;
	}

	@PostMapping(path = "/agregarSemillero")
	public @ResponseBody String agregarSemillero(@RequestParam String nombre, @RequestParam String descripcion,
			@RequestParam String condicion, @RequestParam String profesor, @RequestParam String correo_profesor,
			@RequestParam Boolean estado) {
		Semillero semillero = new Semillero(nombre, descripcion, condicion, profesor, correo_profesor, estado);
		repositorioSemilleroDao.save(semillero);
		return "El semillero " + nombre + " fue agregado satisfactoriamente.";
	}

}
