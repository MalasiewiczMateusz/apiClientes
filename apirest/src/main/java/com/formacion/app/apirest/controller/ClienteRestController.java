package com.formacion.app.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.apirest.entity.Cliente;
import com.formacion.app.apirest.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	@Autowired
	private ClienteService servicio;

	@GetMapping({ "/clientes", "/todos" })
	public List<Cliente> index() {
		return servicio.findAll();
	}

	// Si quiero que dos url utilicen el mismo método, por ejemplo:
	// @GetMapping({"/clientes","/todos"})

	@GetMapping("/clientes/{id}")
	public Cliente findClienteById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return servicio.save(cliente);

	}

	@PutMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {

		Cliente clienteUpdate = servicio.findById(id);
		clienteUpdate.setId(id);
		clienteUpdate.setNombre(cliente.getNombre());
		clienteUpdate.setApellido(cliente.getApellido());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefono(cliente.getTelefono());
		clienteUpdate.setCreateAd(cliente.getCreateAd());

		return servicio.save(clienteUpdate);

	}

	@DeleteMapping("/clientes/{id}")
	public Cliente deleteCliente(@PathVariable Long id) {
		Cliente clienteDeleted= servicio.findById(id);
		servicio.deleteById(id);
		return clienteDeleted;
	}
}
