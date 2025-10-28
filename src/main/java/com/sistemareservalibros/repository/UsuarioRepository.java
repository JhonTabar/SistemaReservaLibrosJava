package com.sistemareservalibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemareservalibros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
