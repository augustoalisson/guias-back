package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.TipoCliente;
import com.guias.repositories.TipoClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoClienteService {

	@Autowired
	private TipoClienteRepository repository;

	public List<TipoCliente> findAll() {
		return repository.findAll();
	}

	public TipoCliente findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhum status localizado com o ID: " + id));
	}

	public TipoCliente insert(TipoCliente _tipoCliente) {
		return repository.save(_tipoCliente);
	}

	public TipoCliente update(Long id, TipoCliente _tipoCliente) {
		try {
			TipoCliente tipoCliente = repository.getReferenceById(id);
			tipoCliente.setDescricao(_tipoCliente.getDescricao());
			tipoCliente.setSigla(_tipoCliente.getSigla());

			return repository.save(tipoCliente);
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
