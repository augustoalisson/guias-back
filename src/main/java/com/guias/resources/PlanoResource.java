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

import com.guias.entities.Plano;
import com.guias.services.PlanoService;

@RestController
@RequestMapping(value = "/planos")
public class PlanoResource {

	@Autowired
	private PlanoService service;

	@GetMapping
	public ResponseEntity<List<Plano>> findAll() {
		List<Plano> planos = service.findAll();
		return ResponseEntity.ok().body(planos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Plano> findById(@PathVariable Long id) {
		Plano plano = service.findById(id);
		return ResponseEntity.ok().body(plano);
	}

	@PostMapping
	public ResponseEntity<Plano> insert(@RequestBody Plano _plano) {
		_plano = service.insert(_plano);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_plano.getId()).toUri();

		return ResponseEntity.created(uri).body(_plano);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Plano> update(@PathVariable Long id, @RequestBody Plano _plano) {
		_plano = service.update(id, _plano);
		return ResponseEntity.ok().body(_plano);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
