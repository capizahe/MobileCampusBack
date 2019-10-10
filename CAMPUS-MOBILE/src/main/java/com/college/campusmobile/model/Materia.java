package com.college.campusmobile.model;
import javax.persistence.*;

import com.college.campusmobile.model.Estudiante;
import com.college.campusmobile.model.Facultad;
import com.college.campusmobile.model.Materia;
import com.college.campusmobile.model.Programa;
import com.college.campusmobile.repository.RepositorioEstudiantes;
import com.college.campusmobile.repository.RepositorioMaterias;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	private Integer cant_creditos;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Programa programa;
	
	
	public Materia() {
		
	}
	
	public Programa getPrograma() {
		return programa;
	}


	public void setPrograma(Programa programa) {
		this.programa = programa;
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

	public Integer getCant_creditos() {
		return cant_creditos;
	}

	public void setCant_creditos(Integer cant_creditos) {
		this.cant_creditos = cant_creditos;
	}



	public Materia(String nombre, Integer cant_creditos, Programa programa) {
		super();
		this.nombre = nombre;
		this.cant_creditos = cant_creditos;
		this.programa = programa;
	}


	


	
	
	
	


}
