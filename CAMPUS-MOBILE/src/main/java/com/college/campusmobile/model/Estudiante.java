package com.college.campusmobile.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Estudiante")
public class Estudiante {
	
	@Id
	private Long id;
	
	@NotNull
	@Column(unique = true)
	private String nombre;
	
	@NotNull
	private String apellido;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Facultad> facultad;
	
	private String telefono;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Materia> materias;
	
	@NotNull
	private String email;
	
	@NotNull
	@Column(unique=true, nullable=false)
	private String usuario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Programa> programas;
	
	public Estudiante(Long id, @NotNull String nombre, @NotNull String apellido, List<Facultad> facultad,
			String telefono, List<Materia> materias, @NotNull String email, @NotNull String usuario,
			Set<Programa> programas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.facultad = facultad;
		this.telefono = telefono;
		this.materias = materias;
		this.email = email;
		this.usuario = usuario;
		this.programas = programas;
	}

	public Estudiante() {
		super();
	}

	public Set<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(Set<Programa> programas) {
		this.programas = programas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Facultad> getFacultad() {
		return facultad;
	}

	public void setFacultad(List<Facultad> facultad) {
		this.facultad = facultad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
