package com.uniquindio.interfaceService;

import java.util.List;
import java.util.Optional;

import com.uniquindio.modelo.Cliente;

public interface IClienteService {
	
	public boolean verificarCliente(String email, String getpassword);

	public int saveCliente(Cliente p);

	public Cliente listarClienteId(Integer id);

	public Cliente verificarClienteRegistrado(String email, String password);

	public List<Cliente> listarClientes();

	public void delete(Integer cedula);

	public Optional<Cliente> listarId(Integer cedula);

	void cambiarDireccion(String direccion, Integer id);


}
