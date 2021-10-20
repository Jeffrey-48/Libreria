package com.uniquindio.modelo;

public class PersonaPassword {
	
	private String nombre;
	private String apellido;
	private Integer cedula;
	private String email;
	
	public PersonaPassword(String nombre, String apellido, Integer cedula, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.email = email;
	}
	
	public PersonaPassword() {
		
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

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
