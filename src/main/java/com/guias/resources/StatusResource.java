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

import com.guias.entities.Status;
import com.guias.services.StatusService;

@RestController
@RequestMapping(value = "/status")
public class StatusResource {

	@Autowired
	private StatusService service;

	@GetMapping
	public ResponseEntity<List<Status>> findAll() {
		List<Status> status = service.findAll();
		return ResponseEntity.ok().body(status);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Status> findById(@PathVariable Long id) {
		Status status = service.findById(id);
		return ResponseEntity.ok().body(status);
	}

	@PostMapping
	public ResponseEntity<Status> insert(@RequestBody Status _status) {
		_status = service.insert(_status);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_status.getId())
				.toUri();

		return ResponseEntity.created(uri).body(_status);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Status> update(@PathVariable Long id, @RequestBody Status _status) {
		_status = service.update(id, _status);
		return ResponseEntity.ok().body(_status);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
