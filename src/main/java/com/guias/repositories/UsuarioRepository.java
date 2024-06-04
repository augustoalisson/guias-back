package com.guias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guias.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

