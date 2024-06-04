package com.guias.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.Guia;
import com.guias.repositories.GuiaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GuiaService {

	@Autowired
	private GuiaRepository repository;

	public List<Guia> findAll() {
		return repository.findAll();
	}

	public Guia findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhuma guia localizada com o ID: " + id));
	}

	public Guia insert(Guia _guia) {
		_guia.setData_vencimento(Instant.now().plus(90, ChronoUnit.DAYS));
		return repository.save(_guia);
	}

	public Guia update(Long id, Guia _guia) {
		try {
			Guia guia = repository.getReferenceById(id);
			guia.setCliente(_guia.getCliente());
			guia.setPrestador(_guia.getPrestador());
			guia.setStatus(_guia.getStatus());
			guia.setData_vencimento(Instant.now().plus(90, ChronoUnit.DAYS));

			return repository.save(guia);
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
