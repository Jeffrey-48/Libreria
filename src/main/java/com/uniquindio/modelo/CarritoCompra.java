package com.uniquindio.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carrito_compra")
public class CarritoCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_carrito;
	
	private Date fechaCreacion;
	
	private Float subtotal;
	
	private Float total;
	
	@ManyToOne
	private Cliente miC;
	
	@ManyToMany
	private List<Producto> productosCarrito;
	

	public CarritoCompra(Date fechaCreacion, Float subTotal, Float total, Cliente miC,
			List<Producto> productosCarrito) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.subtotal = subTotal;
		this.total = total;
		this.miC = miC;
		this.productosCarrito = productosCarrito;
	}

	public CarritoCompra() {
		
	}

	public Integer getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(Integer id_carrito) {
		this.id_carrito = id_carrito;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Float getSubTotal() {
		return subtotal;
	}

	public void setSubTotal(Float subTotal) {
		this.subtotal = subTotal;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public List<Producto> getProductosCarrito() {
		return productosCarrito;
	}

	public void setProductosCarrito(List<Producto> productosCarrito) {
		this.productosCarrito = productosCarrito;
	}
	
	

	public Cliente getMiC() {
		return miC;
	}

	public void setMiC(Cliente miC) {
		this.miC = miC;
	}

	@Override
	public String toString() {
		return "CarritoCompra [id_carrito=" + id_carrito + ", fechaCreacion=" + fechaCreacion + ", subTotal=" + subtotal
				+ ", total=" + total + ", miC=" + miC + ", productosCarrito=" + productosCarrito + "]";
	}

	
	
	
	

}
