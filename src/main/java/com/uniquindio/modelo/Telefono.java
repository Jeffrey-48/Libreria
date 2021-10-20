package com.uniquindio.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="telefono")
public class Telefono {
	
	@Id
	private Integer id;
	
	private String tipo;
	
	private Integer numero;
	
	

	public Telefono(Integer id, String tipo, Integer numero) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public Telefono() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", tipo=" + tipo + ", numero=" + numero + "]";
	}
	
	

	
	
}
