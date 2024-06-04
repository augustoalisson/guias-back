package com.guias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guias.entities.Usuario;
import com.guias.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Nenhum usuário localizado com o ID: " + id));
	}

	public Usuario insert(Usuario _usuario) {
		return repository.save(_usuario);
	}

	public Usuario update(Long id, Usuario _usuario) {
		try {
			Usuario usuario = repository.getReferenceById(id);
			usuario.setNome(_usuario.getNome());
			usuario.setEmail(_usuario.getEmail());
			usuario.setUsuario(_usuario.getUsuario());
			usuario.setNivel_acesso(_usuario.getNivel_acesso());
			usuario.setSenha(_usuario.getSenha());

			return repository.save(usuario);
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
