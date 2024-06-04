package com.guias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guias.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
