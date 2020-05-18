package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_usuario;
	
	@Column(name="nombre")
	@Size(min=1, max=50, message="El campo nombre tiene que tener una longitud minima de 1 caracter y maximo de 50")

	private String nombre;
	
	@Column(name="apellido")
	@Size(min=1, max=50, message="El campo apellido tiene que tener una longitud minima de 1 caracter y maximo de 50")

	private String apellido;
	
	@Column(name="carne")
	@Size(min=7, max=10, message="El campo carne tiene que tener una longitud entre  minimca 7 caractere y maximo de 10s")

	private String carne;
	
	@Column(name="carrera")
	@Size(min=1, max=1000, message="El campo carrera tiene que tener una longitud minima de 1 caracter y maximo de 100")

	private String carrera;
	
	
	public Integer getC_usuario() {
		return c_usuario;
	}
	public void setC_usuario(Integer c_usuario) {
		this.c_usuario = c_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCarne() {
		return carne;
	}
	public void setCarne(String carne) {
		this.carne = carne;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public Estudiante() {
		super();
	}
	
	

}
