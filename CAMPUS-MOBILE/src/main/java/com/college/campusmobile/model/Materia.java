package com.college.campusmobile.model;
import javax.persistence.*;

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
	
	private String profesor;

	public Materia() {
		
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

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public Materia(String nombre, Integer cant_creditos, String profesor) {
		super();
		this.nombre = nombre;
		this.cant_creditos = cant_creditos;
		this.profesor = profesor;
	}


	
	
	
	


}
