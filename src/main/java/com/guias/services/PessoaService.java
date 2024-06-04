package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.Pessoa;
import com.guias.repositories.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhuma pessoa localizada com o ID: " + id));
	}

	public Pessoa insert(Pessoa _pessoa) {
		return repository.save(_pessoa);
	}

	public Pessoa update(Long id, Pessoa _pessoa) {
		try {
			Pessoa pessoa = repository.getReferenceById(id);
			pessoa.setNome(_pessoa.getNome());
			pessoa.setCpf_cnpj(_pessoa.getCpf_cnpj());

			return repository.save(pessoa);
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
