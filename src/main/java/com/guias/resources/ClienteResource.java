package com.guias.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guias.entities.Cliente;
import com.guias.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = service.findAll();
		return ResponseEntity.ok().body(clientes);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente);
	}

	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente _cliente) {
		_cliente = service.insert(_cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_cliente.getId())
				.toUri();

		return ResponseEntity.created(uri).body(_cliente);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente _cliente) {
		_cliente = service.update(id, _cliente);
		return ResponseEntity.ok().body(_cliente);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
