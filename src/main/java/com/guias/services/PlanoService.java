package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.Plano;
import com.guias.repositories.PlanoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlanoService {

	@Autowired
	private PlanoRepository repository;

	public List<Plano> findAll() {
		return repository.findAll();
	}

	public Plano findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhum plano localizado com o ID: " + id));
	}

	public Plano insert(Plano _plano) {
		return repository.save(_plano);
	}

	public Plano update(Long id, Plano _plano) {
		try {
			Plano plano = repository.getReferenceById(id);
			plano.setDescricao(_plano.getDescricao());

			return repository.save(plano);
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
