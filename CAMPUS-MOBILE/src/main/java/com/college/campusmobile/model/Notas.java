package com.college.campusmobile.model;

import javax.persistence.*;

@Entity
@Table(name="notas")
public class Notas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Materia materia;
	
	@OneToOne
	private Estudiante estudiante;
	
	private Double corte1,corte2,corte3;
	
	public Notas(Long id, Materia materia, Estudiante estudiante, Double corte1, Double corte2, Double corte3) {
		super();
		this.id = id;
		this.materia = materia;
		this.estudiante = estudiante;
		this.corte1 = corte1;
		this.corte2 = corte2;
		this.corte3 = corte3;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Notas() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Double getCorte1() {
		return corte1;
	}

	public void setCorte1(Double corte1) {
		this.corte1 = corte1;
	}

	public Double getCorte2() {
		return corte2;
	}

	public void setCorte2(Double corte2) {
		this.corte2 = corte2;
	}

	public Double getCorte3() {
		return corte3;
	}

	public void setCorte3(Double corte3) {
		this.corte3 = corte3;
	}
	
	
	
	
	



	
}
