package com.uniquindio.modelo;

import java.util.Date;

public class ProductoDetalle {
	
	private Integer cedula;
	
	private String nombre_producto;
	
	private String descripcion;
	
	private float valor;
	
	private int cantidad;
	
	private Date fecha;
	

	
	
	
	

	public ProductoDetalle(Integer cedula, String nombre_producto, String descripcion, float valor, int cantidad,
			Date fecha) {
		super();
		this.cedula = cedula;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.valor = valor;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public ProductoDetalle() {
		
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ProductoDetalle [cedula=" + cedula + ", nombre_producto=" + nombre_producto + ", descripcion="
				+ descripcion + ", valor=" + valor + ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
	}
	
	

	
	
	
	
	
	
	
	
	

}
