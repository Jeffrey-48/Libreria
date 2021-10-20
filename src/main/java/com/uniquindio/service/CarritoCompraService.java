package com.uniquindio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.interfaceService.ICarritoCompraService;
import com.uniquindio.interfaces.ICarritoCompra;
import com.uniquindio.modelo.CarritoCompra;
import com.uniquindio.modelo.Cliente;

@Service
public class CarritoCompraService implements ICarritoCompraService{
	
	@Autowired
	private ICarritoCompra data;
	
	
	@Override
	public int saveCarritoCompra(CarritoCompra c) {
		// TODO Auto-generated method stub
		int res = 0;
		CarritoCompra e = data.save(c);
		if(!e.equals(null)) {
			res = 1;
		}
		return res;
	}


	@Override
	public List<CarritoCompra> listarCarritos() {
		// TODO Auto-generated method stub
		return (List<CarritoCompra>)data.findAll();
	}
	
	@Override
	public Optional<CarritoCompra> listarId(Integer id_carrito){
		
		return data.findById(id_carrito);
	}

}
