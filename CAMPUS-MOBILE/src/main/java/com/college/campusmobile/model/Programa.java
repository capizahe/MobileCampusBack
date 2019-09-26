package com.college.campusmobile.model;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="programa")
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "programa")
	@JsonManagedReference
	private List<Credito> creditos;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Facultad facultad;
	

	public Programa(String nombre, List<Credito> creditos) {
		super();
		this.nombre = nombre;
		this.creditos = creditos;
	}
	
	public Programa() {
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

	public List<Credito> getCreditos_academicos() {
		return creditos;
	}

	public void setCreditos_academicos(List<Credito> creditos_academicos) {
		this.creditos = creditos_academicos;
	}
	
	
	
	
	
}
