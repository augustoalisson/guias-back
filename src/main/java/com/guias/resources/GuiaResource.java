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

import com.guias.entities.Guia;
import com.guias.services.GuiaService;

@RestController
@RequestMapping(value = "/guias")
public class GuiaResource {
	@Autowired
	private GuiaService service;

	@GetMapping
	public ResponseEntity<List<Guia>> findAll() {
		List<Guia> guias = service.findAll();
		return ResponseEntity.ok().body(guias);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Guia> findById(@PathVariable Long id) {
		Guia guia = service.findById(id);
		return ResponseEntity.ok().body(guia);
	}

	@PostMapping
	public ResponseEntity<Guia> insert(@RequestBody Guia _guia) {
		_guia = service.insert(_guia);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_guia.getId()).toUri();

		return ResponseEntity.created(uri).body(_guia);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Guia> update(@PathVariable Long id, @RequestBody Guia _guia) {
		_guia = service.update(id, _guia);
		return ResponseEntity.ok().body(_guia);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
