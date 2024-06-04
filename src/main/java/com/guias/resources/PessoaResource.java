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

import com.guias.entities.Pessoa;
import com.guias.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService service;

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> pessoas = service.findAll();
		return ResponseEntity.ok().body(pessoas);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
		Pessoa pessoa = service.findById(id);
		return ResponseEntity.ok().body(pessoa);
	}

	@PostMapping
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa _pessoa) {
		_pessoa = service.insert(_pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_pessoa.getId())
				.toUri();

		return ResponseEntity.created(uri).body(_pessoa);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa _pessoa) {
		_pessoa = service.update(id, _pessoa);
		return ResponseEntity.ok().body(_pessoa);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
