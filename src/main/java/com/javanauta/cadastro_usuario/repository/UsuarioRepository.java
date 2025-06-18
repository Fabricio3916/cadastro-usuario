package com.javanauta.cadastro_usuario.repository;

import com.javanauta.cadastro_usuario.model.UsuarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    Optional<UsuarioModel> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
