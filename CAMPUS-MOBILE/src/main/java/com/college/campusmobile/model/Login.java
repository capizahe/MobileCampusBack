package com.college.campusmobile.model;
import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Estudiante estudiante;
	
	private String contrasena;

	public Login(Estudiante estudiante, String contrasena) {
		super();
		this.estudiante = estudiante;
		this.contrasena = contrasena;
	}
	public Login() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
