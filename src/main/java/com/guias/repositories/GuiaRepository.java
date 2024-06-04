package com.guias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guias.entities.Guia;

public interface GuiaRepository extends JpaRepository<Guia, Long> {

}
