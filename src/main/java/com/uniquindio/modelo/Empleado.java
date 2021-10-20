package com.uniquindio.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	
	private String nombre;
	private String apellido;
	
	@Id
	private Integer cedula;
	private String email;
	private Integer salario;
	private String horario;
	
	@OneToMany
	private List<Telefono> telefono;
	private String password;
	
	public Empleado(String nombre, String apellido, Integer cedula, String email, Integer salario, String horario,
			List<Telefono> telefono, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.email = email;
		this.salario = salario;
		this.horario = horario;
		this.telefono = telefono;
		this.password = password;
	}

	public Empleado() {
		
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


	public Integer getSalario() {
		return salario;
	}


	public void setSalario(Integer salario) {
		this.salario = salario;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", email=" + email
				+ ", salario=" + salario + ", horario=" + horario + ", telefono=" + telefono + "]";
	}	

}
