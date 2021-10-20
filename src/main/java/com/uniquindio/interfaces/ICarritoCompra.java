package com.uniquindio.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.modelo.CarritoCompra;
import com.uniquindio.modelo.Cliente;

@Repository
public interface ICarritoCompra extends CrudRepository<CarritoCompra, Integer>{

	

}
