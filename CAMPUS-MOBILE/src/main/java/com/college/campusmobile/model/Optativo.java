package com.college.campusmobile.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "optativo") 
public class Optativo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Credito credito;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String instructor;
    
    @NotNull
    private String horario;
    
    @NotNull
    private Integer cantidad_creditos;
    
    public Optativo() {
    	super();
    }

	public Optativo(Long id, Credito credito, String nombre, String instructor, String horario,
			Integer cantidad_creditos) {
		super();
		this.id = id;
		this.credito = credito;
		this.nombre = nombre;
		this.instructor = instructor;
		this.horario = horario;
		this.cantidad_creditos = cantidad_creditos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getCantidad_creditos() {
		return cantidad_creditos;
	}

	public void setCantidad_creditos(Integer cantidad_creditos) {
		this.cantidad_creditos = cantidad_creditos;
	}
    
    
	
	
}
