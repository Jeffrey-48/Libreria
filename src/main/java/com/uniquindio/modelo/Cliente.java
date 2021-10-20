package com.uniquindio.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	private String nombre;
	
	@Id
	private Integer cedula;
	
	private String email;
	
	private String apellido;
	
	private String password;
	
	@OneToMany
	private List<Telefono> telefono;
	
	@OneToMany(mappedBy = "miC")
	private List<CarritoCompra> misCarros;
	
	private String direccion;

	
	
	
	public Cliente(String nombre, Integer cedula, String email, String apellido, String password,
			List<Telefono> telefono, List<CarritoCompra> misCarros, String direccion) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.email = email;
		this.apellido = apellido;
		this.password = password;
		this.telefono = telefono;
		this.misCarros = misCarros;
		this.direccion = direccion;
	}
	
	public Cliente()
	{
		
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public List<Telefono> getTelefono() {
		return telefono;
	}
	public void setTelefono(List<Telefono> telefono) {
		this.telefono = telefono;
	}
	
	
	public List<CarritoCompra> getMisCarros() {
		return misCarros;
	}
	public void setMisCarros(List<CarritoCompra> misCarros) {
		this.misCarros = misCarros;
	}
	
	
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", cedula=" + cedula + ", email=" + email + ", apellido=" + apellido
				+ ", password=" + password + ", telefono=" + telefono + ", misCarros=" + misCarros + ", direccion="
				+ direccion + "]";
	}

	
	
	
	
}
