package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.Status;
import com.guias.repositories.StatusRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StatusService {

	@Autowired
	private StatusRepository repository;

	public List<Status> findAll() {
		return repository.findAll();
	}

	public Status findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhum status localizado com o ID: " + id));
	}

	public Status insert(Status _status) {
		return repository.save(_status);
	}

	public Status update(Long id, Status _status) {
		try {
			Status status = repository.getReferenceById(id);
			status.setDescricao(_status.getDescricao());

			return repository.save(status);
		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());
		}

	}

}
