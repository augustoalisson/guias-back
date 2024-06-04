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

import com.guias.entities.Usuario;
import com.guias.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = service.findAll();
		return ResponseEntity.ok().body(usuarios);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario usuario = service.findById(id);
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario _usuario) {
		_usuario = service.insert(_usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_usuario.getId())
				.toUri();

		return ResponseEntity.created(uri).body(_usuario);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario _usuario) {
		_usuario = service.update(id, _usuario);
		return ResponseEntity.ok().body(_usuario);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
