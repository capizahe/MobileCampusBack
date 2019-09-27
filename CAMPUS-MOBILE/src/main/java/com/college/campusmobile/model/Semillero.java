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
	
	private String  profesor;
	
	private String correo_profesor;
	
	private Boolean estado;
	
	public Semillero() {
		super();
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

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getCorreo_profesor() {
		return correo_profesor;
	}

	public void setCorreo_profesor(String correo_profesor) {
		this.correo_profesor = correo_profesor;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Semillero(String nombre, String descripcion, String condicion, String profesor,
			String correo_profesor, Boolean estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.condicion = condicion;
		this.profesor = profesor;
		this.correo_profesor = correo_profesor;
		this.estado = estado;
	}
	
	

}
