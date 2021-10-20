package com.uniquindio.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.modelo.Producto;

@Repository
public interface IProducto extends CrudRepository<Producto, Integer>{

}
