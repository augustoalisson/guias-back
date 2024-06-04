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

import com.guias.entities.TipoCliente;
import com.guias.services.TipoClienteService;

@RestController
@RequestMapping(value = "/tipos-cliente")
public class TipoClienteResource {

	@Autowired
	private TipoClienteService service;

	@GetMapping
	public ResponseEntity<List<TipoCliente>> findAll() {
		List<TipoCliente> tipos = service.findAll();
		return ResponseEntity.ok().body(tipos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoCliente> findById(@PathVariable Long id) {
		TipoCliente tipo = service.findById(id);
		return ResponseEntity.ok().body(tipo);
	}

	@PostMapping
	public ResponseEntity<TipoCliente> insert(@RequestBody TipoCliente _tipo) {
		_tipo = service.insert(_tipo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_tipo.getId()).toUri();

		return ResponseEntity.created(uri).body(_tipo);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TipoCliente> update(@PathVariable Long id, @RequestBody TipoCliente _tipo) {
		_tipo = service.update(id, _tipo);
		return ResponseEntity.ok().body(_tipo);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
