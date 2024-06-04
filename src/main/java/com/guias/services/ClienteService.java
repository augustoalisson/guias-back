package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.Cliente;
import com.guias.repositories.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhum cliente localizado com o ID: " + id));
	}

	public Cliente insert(Cliente _pessoa) {
		return repository.save(_pessoa);
	}

	public Cliente update(Long id, Cliente _cliente) {
		try {
			Cliente cliente = repository.getReferenceById(id);
			cliente.setPessoa(_cliente.getPessoa());
			cliente.setTipo(_cliente.getTipo());
			cliente.setTitular(_cliente.getTitular());
			cliente.setPlano(_cliente.getPlano());

			return repository.save(cliente);
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
