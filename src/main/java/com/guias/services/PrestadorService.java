package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.Prestador;
import com.guias.repositories.PrestadorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PrestadorService {

	@Autowired
	private PrestadorRepository repository;

	public List<Prestador> findAll() {
		return repository.findAll();
	}

	public Prestador findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhum prestador localizado com o ID: " + id));
	}

	public Prestador insert(Prestador _prestador) {
		return repository.save(_prestador);
	}

	public Prestador update(Long id, Prestador _prestador) {
		try {
			Prestador prestador = repository.getReferenceById(id);
			prestador.setPessoa(_prestador.getPessoa());

			return repository.save(prestador);
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
