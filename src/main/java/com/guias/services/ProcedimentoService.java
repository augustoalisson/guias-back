package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.Procedimento;
import com.guias.repositories.ProcedimentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository repository;

	public List<Procedimento> findAll() {
		return repository.findAll();
	}

	public Procedimento findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhum procedimento localizado com o ID: " + id));
	}

	public Procedimento insert(Procedimento _procedimento) {
		return repository.save(_procedimento);
	}

	public Procedimento update(Long id, Procedimento _procedimento) {
		try {
			Procedimento procedimento = repository.getReferenceById(id);
			procedimento.setCodigo_tiss(_procedimento.getCodigo_tiss());
			procedimento.setValor(_procedimento.getValor());

			return repository.save(procedimento);
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
