package com.college.campusmobile.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.campusmobile.model.Estudiante;
import com.college.campusmobile.model.Login;
import com.college.campusmobile.repository.RepositorioEstudiantes;
import com.college.campusmobile.repository.RepositorioLogin;

@Controller
@RequestMapping("/login")
public class ControladorLogin {

	@Autowired
	private RepositorioLogin repositorioLoginDao;

	@Autowired
	private RepositorioEstudiantes repositorioEstudianteDao;

	@PostMapping(path = "/estudiante")
	public @ResponseBody Estudiante loginEstudiante(@RequestParam String usuario, @RequestParam String password){
		Optional<Estudiante> estudiante = repositorioEstudianteDao.findEstudianteByUsuario(usuario);
		if(estudiante.isPresent()) {
			Optional<Login> login_estudiante = repositorioLoginDao.findLoginByEstudiante(estudiante.get());
			if(login_estudiante.isPresent()) {
				if(login_estudiante.get().getContrasena().equals(password)){
					return login_estudiante.get().getEstudiante();
				}
				return null;	
			}
		}
		return null;
	}
    @PostMapping(path = "/agregar_estudiante")
	public @ResponseBody String agregarEstudiante(@RequestParam String usuario, @RequestParam String password) {
		Optional<Estudiante> estudiante = repositorioEstudianteDao.findEstudianteByUsuario(usuario);
		if(estudiante.isPresent()) {
			Optional<Login> login_estudiante = repositorioLoginDao.findLoginByEstudiante(estudiante.get());
			if(login_estudiante.isPresent()) return "El estudiante "+estudiante.get()+" ya se encuentra agregado.";
			Login login = new Login(estudiante.get(), password);
			repositorioLoginDao.save(login);
			return "El estudiante "+ estudiante.get().getUsuario()+ " agregado satisfactoriamente.";
		}
		else return "El estudiante no se encuentra";
	}






}
