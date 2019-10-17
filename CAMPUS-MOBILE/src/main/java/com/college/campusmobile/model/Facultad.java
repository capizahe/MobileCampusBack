package com.college.campusmobile.model;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Facultad")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id; 
	
	@Column(unique=true)
	private String nombre;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("facultad")	
	private List<Programa> programa;
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Semillero> semilleros;
	
	public Facultad() {
		super();
	}

	public Facultad(String nombre, List<Programa> programa, List<Semillero> semilleros) {
		super();
		this.nombre = nombre;
		this.programa = programa;
		this.semilleros = semilleros;
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

	public List<Programa> getPrograma() {
		return programa;
	}

	public void setPrograma(List<Programa> programa) {
		this.programa = programa;
	}

	public List<Semillero> getSemilleros() {
		return semilleros;
	}

	public void setSemilleros(List<Semillero> semilleros) {
		this.semilleros = semilleros;
	}

	
	
	
}
