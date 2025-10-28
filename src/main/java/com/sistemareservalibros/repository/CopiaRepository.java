package com.sistemareservalibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemareservalibros.model.Copia;

public interface CopiaRepository extends JpaRepository<Copia, Integer> {
}