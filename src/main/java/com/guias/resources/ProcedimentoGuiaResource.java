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

import com.guias.entities.ProcedimentoGuia;
import com.guias.services.ProcedimentoGuiaService;

@RestController
@RequestMapping(value = "/pguias")
public class ProcedimentoGuiaResource {

	@Autowired
	private ProcedimentoGuiaService service;

	@GetMapping
	public ResponseEntity<List<ProcedimentoGuia>> findAll() {
		List<ProcedimentoGuia> pguia = service.findAll();
		return ResponseEntity.ok().body(pguia);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProcedimentoGuia> findById(@PathVariable Long id) {
		ProcedimentoGuia pguia = service.findById(id);
		return ResponseEntity.ok().body(pguia);
	}

	@PostMapping
	public ResponseEntity<ProcedimentoGuia> insert(@RequestBody ProcedimentoGuia _pguia) {
		_pguia = service.insert(_pguia);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_pguia.getId()).toUri();

		return ResponseEntity.created(uri).body(_pguia);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProcedimentoGuia> update(@PathVariable Long id, @RequestBody ProcedimentoGuia _pguia) {
		_pguia = service.update(id, _pguia);
		return ResponseEntity.ok().body(_pguia);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
