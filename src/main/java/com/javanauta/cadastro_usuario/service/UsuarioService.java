package com.javanauta.cadastro_usuario.service;

import com.javanauta.cadastro_usuario.model.UsuarioModel;
import com.javanauta.cadastro_usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(UsuarioModel usuario){
        repository.saveAndFlush(usuario);
    }

    public  UsuarioModel buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, UsuarioModel usuario){
        UsuarioModel usuarioEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado")
        );
        UsuarioModel usuarioAtualizado = UsuarioModel.builder()
                .email(usuario.getEmail() != null ?
                        usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ?
                        usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
    }

}
