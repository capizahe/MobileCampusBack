package com.college.campusmobile.model;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bienestar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String modalidad;
	private String profesor;
	
	@Column(name="descripcion", length=2000)
	private String descripcion;
	
	private String correo;
	private String tipo;
	
	public Bienestar() {
		
	}
	
	public Bienestar(String nombre, String modalidad, String profesor, String descripcion, String correo,
			String tipo) {
		super();
		this.nombre = nombre;
		this.modalidad = modalidad;
		this.profesor = profesor;
		this.descripcion = descripcion;
		this.correo = correo;
		this.tipo = tipo;
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

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getProfresor() {
		return profesor;
	}

	public void setProfresor(String profesor) {
		this.profesor = profesor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	

}
