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

import com.guias.entities.Prestador;
import com.guias.services.PrestadorService;

@RestController
@RequestMapping(value = "/prestadores")
public class PrestadorResource {

	@Autowired
	private PrestadorService service;

	@GetMapping
	public ResponseEntity<List<Prestador>> findAll() {
		List<Prestador> prestadores = service.findAll();
		return ResponseEntity.ok().body(prestadores);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Prestador> findById(@PathVariable Long id) {
		Prestador prestador = service.findById(id);
		return ResponseEntity.ok().body(prestador);
	}

	@PostMapping
	public ResponseEntity<Prestador> insert(@RequestBody Prestador _prestador) {
		_prestador = service.insert(_prestador);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_prestador.getId())
				.toUri();

		return ResponseEntity.created(uri).body(_prestador);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Prestador> update(@PathVariable Long id, @RequestBody Prestador _prestador) {
		_prestador = service.update(id, _prestador);
		return ResponseEntity.ok().body(_prestador);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
