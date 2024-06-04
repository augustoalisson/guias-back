package com.guias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guias.entities.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long> {

}
