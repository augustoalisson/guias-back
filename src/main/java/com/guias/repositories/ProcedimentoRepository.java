package com.guias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guias.entities.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {

}
