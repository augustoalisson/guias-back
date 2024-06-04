package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.ProcedimentoGuia;
import com.guias.repositories.ProcedimentoGuiaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProcedimentoGuiaService {

	@Autowired
	private ProcedimentoGuiaRepository repository;

	public List<ProcedimentoGuia> findAll() {
		return repository.findAll();
	}

	public ProcedimentoGuia findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhum procedimento guia localizado com o ID: " + id));
	}

	public ProcedimentoGuia insert(ProcedimentoGuia _procedimento) {
		return repository.save(_procedimento);
	}

	public ProcedimentoGuia update(Long id, ProcedimentoGuia _pguia) {
		try {
			ProcedimentoGuia pguia = repository.getReferenceById(id);
			pguia.setGuia(_pguia.getGuia());
			pguia.setProcedimento(_pguia.getProcedimento());

			return repository.save(pguia);
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
