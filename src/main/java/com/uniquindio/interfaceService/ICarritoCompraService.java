package com.uniquindio.interfaceService;

import java.util.List;
import java.util.Optional;

import com.uniquindio.modelo.CarritoCompra;

public interface ICarritoCompraService {

	public int saveCarritoCompra(CarritoCompra c);
	
	public List<CarritoCompra> listarCarritos();

	public Optional<CarritoCompra> listarId(Integer id_carrito);

	

}
