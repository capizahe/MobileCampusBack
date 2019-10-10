package services;

import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.campusmobile.model.Estudiante;
import com.college.campusmobile.model.Facultad;
import com.college.campusmobile.model.Materia;
import com.college.campusmobile.model.Programa;
import com.college.campusmobile.repository.RepositorioEstudiantes;
import com.college.campusmobile.repository.RepositorioMaterias;

@RestController
public class ControladorEstudiante {

	@Autowired
	private RepositorioEstudiantes repositorioEstudiantesDAO;

	@Autowired
	private RepositorioMaterias repositorioMateriasDao;

	@RequestMapping("/estudiantes/verEstudiantes")
	public @ResponseBody Iterable<Estudiante> verEstudiantes() {
		return repositorioEstudiantesDAO.findAll();
	}

	@RequestMapping("/estudiantes/verEstudiantePorUsuario")
	public @ResponseBody Estudiante verEstudiantePorUsuario(@RequestParam String usuario) {
		Optional<Estudiante> estudiante = repositorioEstudiantesDAO.findEstudianteByUsuario(usuario);
		if (estudiante.isPresent())
			return estudiante.get();
		else
			return null;
	}

	@RequestMapping("/estudiantes/verEstudiantePorId")
	public @ResponseBody Estudiante verEstudiantePorId(@RequestParam Long id_usuario) {
		Optional<Estudiante> estudiante = repositorioEstudiantesDAO.findById(id_usuario);
		if (estudiante.isPresent())
			return estudiante.get();
		else
			return null;
	}

	@RequestMapping(path = "/estudiantes/agregarEstudiante", method = RequestMethod.POST)
	public @ResponseBody String agregarEstudiante(@RequestParam Long id, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam List<Facultad> facultad, @RequestParam String telefono,
			@RequestParam List<Materia> materias, @RequestParam String email, @RequestParam String usuario,
			@RequestParam List<Programa> programa) {
		
		Estudiante estudiante = new Estudiante(id, nombre, apellido, facultad, telefono, materias, email, usuario,
				programa);
		repositorioEstudiantesDAO.save(estudiante);
		return "El estudiante " + estudiante.getNombre() + " fue agregado satisfactoriamente";
	}

	@RequestMapping(path = "/estudiantes/agregarEstudianteBasico", method = RequestMethod.POST)
	public @ResponseBody String agregarEstudiante(@RequestParam Long id, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam String telefono, @RequestParam String email,
			@RequestParam String usuario) {
		if (!repositorioEstudiantesDAO.existsById(id)) {
			Estudiante estudiante = new Estudiante(id, nombre, apellido, new ArrayList<Facultad>(), telefono,
					new ArrayList<Materia>(), email, usuario, new ArrayList<Programa>());
			repositorioEstudiantesDAO.save(estudiante);
			return "El estudiante " + estudiante.getNombre() + " fue agregado satisfactoriamente";
		} else
			return "El estudiante " + nombre + " ya es encuentra en el sistema";
	}

	@RequestMapping("/estudiantes/verProgramasPorEstudiante")
	public Iterable<Programa> verProgramasPorEstudiante(@RequestParam Long id) {
		Estudiante estudiante = repositorioEstudiantesDAO.findById(id).get();
		return estudiante.getProgramas();
	}

	@RequestMapping(path = "/estudiantes/agregarMateriaEstudiante", method = RequestMethod.POST)
	public @ResponseBody String agregarMateriaEstudiante(@RequestParam Long id, @RequestParam Long id_materia) {
		Optional<Materia> materia = repositorioMateriasDao.findById(id_materia);
		Optional<Estudiante> estudiante = repositorioEstudiantesDAO.findById(id);
		if (materia.isPresent() & estudiante.isPresent() && !estudiante.get().getMaterias().contains(materia.get())) {
			repositorioEstudiantesDAO.deleteById(id);
			estudiante.get().getMaterias().add(materia.get());
			repositorioEstudiantesDAO.save(estudiante.get());
			return "La materia " + materia.get().getNombre() + " se ha agregado correctamente al estudiante "
					+ estudiante.get().getNombre();
		} else {
			return "No se pudo agregar la materia al estudiante";
		}
	}

}
