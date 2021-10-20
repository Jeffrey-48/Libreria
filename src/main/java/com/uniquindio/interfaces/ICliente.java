package com.uniquindio.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.modelo.Cliente;

@Repository
public interface ICliente extends CrudRepository<Cliente, Integer>{

}
