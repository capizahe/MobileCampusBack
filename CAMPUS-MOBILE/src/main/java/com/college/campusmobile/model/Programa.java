package com.college.campusmobile.model;
import javax.persistence.*;

@Entity
@Table(name="programa")
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	@OneToOne
	private Credito creditos_academicos;

	public Programa(Long id, String nombre, Credito creditos_academicos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.creditos_academicos = creditos_academicos;
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

	public Credito getCreditos_academicos() {
		return creditos_academicos;
	}

	public void setCreditos_academicos(Credito creditos_academicos) {
		this.creditos_academicos = creditos_academicos;
	}
	
	
	
	
	
}
