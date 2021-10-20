package com.uniquindio.interfaceService;

import java.util.List;
import java.util.Optional;

import com.uniquindio.modelo.Producto;

public interface IProductoService {

	public List<Producto> listarProductos();

	public Producto buscarPorId(Integer id_producto);

	public int save(Producto p);

	public void delete(Integer id_producto);

	public Optional<Producto> listarId(Integer id_producto);

}
