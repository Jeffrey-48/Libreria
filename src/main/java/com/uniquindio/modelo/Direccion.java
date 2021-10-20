package com.uniquindio.modelo;

public class Direccion {
	
	private String direccion;

	
	
	public Direccion(String direccion) {
		super();
		this.direccion = direccion;
	}

	public Direccion() {
		
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Direccion [direccion=" + direccion + "]";
	}
	
	

}
