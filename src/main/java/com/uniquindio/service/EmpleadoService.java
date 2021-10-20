package com.uniquindio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.interfaceService.IEmpleadoService;
import com.uniquindio.interfaces.IEmpleado;
import com.uniquindio.modelo.Cliente;
import com.uniquindio.modelo.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService{
	
	@Autowired
	private IEmpleado data;
	
	

	@Override
	public List<Empleado> listar() {
		// TODO Auto-generated method stub
		return (List<Empleado>)data.findAll();
	}

	@Override
	public Optional<Empleado> listarId(Integer id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Empleado p) {
		// TODO Auto-generated method stub
		int res = 0;
		Empleado e = data.save(p);
		if(!e.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(Integer id) {
		data.deleteById(id);
	}

	@Override
	public boolean verificar(String email, String password) {
		boolean centi = false;
		List<Empleado> miE = (List<Empleado>) data.findAll();
		for (Empleado empleado : miE) {
			String auxEmail = empleado.getEmail();
			String auxPassword = empleado.getPassword();
			if(auxEmail.equals(email) && auxPassword.equals(password)) {
				centi = true;
			}
		}
		return centi;
	}

	

}
