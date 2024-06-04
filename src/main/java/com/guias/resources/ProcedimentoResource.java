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

import com.guias.entities.Procedimento;
import com.guias.services.ProcedimentoService;

@RestController
@RequestMapping(value = "/procedimentos")
public class ProcedimentoResource {

	@Autowired
	private ProcedimentoService service;

	@GetMapping
	public ResponseEntity<List<Procedimento>> findAll() {
		List<Procedimento> procedimentos = service.findAll();
		return ResponseEntity.ok().body(procedimentos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Procedimento> findById(@PathVariable Long id) {
		Procedimento procedimento = service.findById(id);
		return ResponseEntity.ok().body(procedimento);
	}

	@PostMapping
	public ResponseEntity<Procedimento> insert(@RequestBody Procedimento _procedimento) {
		_procedimento = service.insert(_procedimento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_procedimento.getId())
				.toUri();

		return ResponseEntity.created(uri).body(_procedimento);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Procedimento> update(@PathVariable Long id, @RequestBody Procedimento _procedimento) {
		_procedimento = service.update(id, _procedimento);
		return ResponseEntity.ok().body(_procedimento);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
