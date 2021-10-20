package com.uniquindio.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.modelo.Empleado;

@Repository
public interface IEmpleado extends CrudRepository<Empleado, Integer>{

}
