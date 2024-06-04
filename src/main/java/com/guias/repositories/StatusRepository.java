package com.guias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guias.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
