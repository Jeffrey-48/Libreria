package com.uniquindio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.interfaceService.IProductoService;
import com.uniquindio.interfaces.IProducto;
import com.uniquindio.modelo.Producto;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProducto data;
	
	@Override
	public List<Producto> listarProductos() {
		return (List<Producto>)data.findAll();
	}

	@Override
	public Producto buscarPorId(Integer id_producto) {
		Optional<Producto> miP = data.findById(id_producto);
		return miP.get();
	}

	@Override
	public int save(Producto p) {
		int res = 0;
		Producto miP = data.save(p);
		if(!p.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(Integer id_producto) {
		data.deleteById(id_producto);
		
	}

	@Override
	public Optional<Producto> listarId(Integer id_producto) {
		return data.findById(id_producto);
	}
	
}
