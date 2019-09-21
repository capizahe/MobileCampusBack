package com.college.campusmobile.model;
import javax.persistence.*;

@Entity
@Table(name = "Facultad")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id; 
	
	private String nombre;
	
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Programa programa;
	
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Semillero semillero;
	
	public Facultad() {
		super();
	}

	public Facultad(Long id, String nombre, Programa programa, Semillero semillero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.programa = programa;
		this.semillero = semillero;
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

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Semillero getSemillero() {
		return semillero;
	}

	public void setSemillero(Semillero semillero) {
		this.semillero = semillero;
	}
	
	
	
}
