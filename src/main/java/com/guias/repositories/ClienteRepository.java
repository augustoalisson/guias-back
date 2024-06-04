package com.guias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guias.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
