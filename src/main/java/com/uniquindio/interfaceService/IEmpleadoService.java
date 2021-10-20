package com.uniquindio.interfaceService;

import java.util.List;
import java.util.Optional;

import com.uniquindio.modelo.Cliente;
import com.uniquindio.modelo.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> listar();
	
	public Optional<Empleado> listarId(Integer id);
	
	public int save(Empleado p);
	
	public void delete(Integer id);

	public boolean verificar(String email, String password);

}
