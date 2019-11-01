package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.campusmobile.model.Bienestar;
import com.college.campusmobile.repository.RepositorioBienestar;

@RestController
@RequestMapping("/bienestar")
public class ControladorBienestar {

	@Autowired
	private RepositorioBienestar repositorioBienestarDao;
	
	@RequestMapping(path = "/verCursos")
	public Iterable<Bienestar> verCursos(){
		return repositorioBienestarDao.findAll();
	}
	
	@RequestMapping(path = "/verCursosCulturales")
	public Iterable<Bienestar> verCursosCulturales(){
		return repositorioBienestarDao.findAllByTipo("cultural");
	}
	
	@RequestMapping(path = "/verCursosDeportes")
	public Iterable<Bienestar> verCursosDeportes(){
		return repositorioBienestarDao.findAllByTipo("deporte");
	}
	
	@RequestMapping(path = "/agregarCurso")
	public String agregarCurso(@RequestParam String nombre, @RequestParam String modalidad, @RequestParam String profesor, @RequestParam String descripcion, @RequestParam String correo, @RequestParam String tipo) {
		Bienestar curso = new Bienestar(nombre,modalidad,profesor,descripcion,correo,tipo);
		Optional<Bienestar> _curso = repositorioBienestarDao.findBienestarByNombre(nombre);
		if(_curso.isEmpty()) {
			repositorioBienestarDao.save(curso);
			return "El curso "+nombre+" fue agregado satisfactoriamente";
		}return "El curso "+_curso.get().getNombre()+ " modalidad "+ _curso.get().getModalidad() +" ya se encuentra agregado";
	}
	
	@RequestMapping(path= "/eliminarCurso")
	public String eliminarCurso(@RequestParam String nombre) {
		Optional<Bienestar> curso = repositorioBienestarDao.findBienestarByNombre(nombre);
		if(curso.isPresent()) {
			repositorioBienestarDao.delete(curso.get());
			return "El curso "+curso.get().getNombre()+" fue eliminado correctamente ";
		}else return "El curso "+ nombre +" no se encuentra presente";
	}
}
