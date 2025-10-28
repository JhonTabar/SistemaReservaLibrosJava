package com.sistemareservalibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemareservalibros.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    boolean existsByCopia_Id(Integer id);
    void deleteByCopia_Id(Integer id);
}