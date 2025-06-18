package com.javanauta.cadastro_usuario.controller;

import com.javanauta.cadastro_usuario.model.UsuarioModel;
import com.javanauta.cadastro_usuario.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioModel usuario){
        service.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<UsuarioModel> buscarUsuarioPorEmail (@RequestParam String email){
        return ResponseEntity.ok(service.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        service.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody UsuarioModel usuario ){

        service.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}
