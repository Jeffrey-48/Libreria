package com.uniquindio.modelo;

import java.util.Date;


public class Venta {
	
	private Integer id_carrito;
	
	private Integer cedula_cliente;
	
	private float valorTotal;
	
	private Date fechaCreacion;
	
	
	

	public Venta(Integer id_carrito, Integer cedula_cliente, float valorTotal, Date fechaCreacion) {
		super();
		this.id_carrito = id_carrito;
		this.cedula_cliente = cedula_cliente;
		this.valorTotal = valorTotal;
		this.fechaCreacion = fechaCreacion;
	}
	
	public Venta() {
		
	}

	public Integer getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(Integer id_carrito) {
		this.id_carrito = id_carrito;
	}

	public Integer getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(Integer cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Venta [id_carrito=" + id_carrito + ", cedula_cliente=" + cedula_cliente + ", valorTotal=" + valorTotal
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	
	
	
	

}
