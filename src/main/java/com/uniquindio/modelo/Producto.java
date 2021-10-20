package com.uniquindio.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	private Integer id_producto;
	private String nombre;
	private String descripcion;
	private String referencia;
	private Integer talla;
	private Integer valor;
	private Integer cantidadDisponible;
	private String categoria;
	
	@ManyToMany
	private List<CarritoCompra> misCarritos;
	
	@ManyToOne
	private Coleccion coleccionProducto;
	
	
	
	
	
	
	public Producto(Integer id_producto, String nombre, String descripcion, String referencia, Integer talla,
			Integer valor, Integer cantidadDisponible, String categoria, List<CarritoCompra> misCarritos,
			Coleccion coleccionProducto) {
		
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.referencia = referencia;
		this.talla = talla;
		this.valor = valor;
		this.cantidadDisponible = cantidadDisponible;
		this.categoria = categoria;
		this.misCarritos = misCarritos;
		this.coleccionProducto = coleccionProducto;
	}




	public Producto() {
		
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Integer getTalla() {
		return talla;
	}
	public void setTalla(Integer talla) {
		this.talla = talla;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	public List<CarritoCompra> getMisCarritos() {
		return misCarritos;
	}
	public void setMisCarritos(List<CarritoCompra> misCarritos) {
		this.misCarritos = misCarritos;
	}
	
	
	
	public Coleccion getColeccionProducto() {
		return coleccionProducto;
	}




	public void setColeccionProducto(Coleccion coleccionProducto) {
		this.coleccionProducto = coleccionProducto;
	}




	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", referencia=" + referencia + ", talla=" + talla + ", valor=" + valor + ", cantidadDisponible="
				+ cantidadDisponible + ", categoria=" + categoria + ", misCarritos=" + misCarritos
				+ ", coleccionProducto=" + coleccionProducto + "]";
	}


	
	
	
	
}
