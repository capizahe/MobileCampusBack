package com.college.campusmobile.model;
import javax.persistence.*;

@Entity
@Table(name="semillero")
public class Semillero {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;
	
	@Column(name="descripcion", length=2000)
	private String descripcion;
	
	@Column(name="condicion", length=2000)
	private String condicion;
	
	@OneToOne
	private Profesor profesor;
	
	private Boolean estado;
	
	public Semillero() {
		super();
	}

	public Semillero(String nombre, String descripcion, String condicion, Profesor profesor, Boolean estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.profesor = profesor;
		this.estado = estado;
		this.condicion = condicion;
	}

	public String getCondicion() {
		return condicion;
	}
	
	public void setCondicion(String condicion) {
		this.condicion = condicion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
