package com.formacion.app.apirest.service;

import java.util.List;

import com.formacion.app.apirest.entity.Cliente;

public interface ClienteService {
	public List<Cliente> findAll();
	public Cliente findById(Long id);
	Cliente save(Cliente cliente);
	public void deleteById(Long id);
	
	
}
