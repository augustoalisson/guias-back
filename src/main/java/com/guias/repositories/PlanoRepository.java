package com.guias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guias.entities.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {

}