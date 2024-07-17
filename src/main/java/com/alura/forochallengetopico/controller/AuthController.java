package com.alura.forochallengetopico.controller;

import com.alura.forochallengetopico.exception.ErrorException;
import com.alura.forochallengetopico.model.AuthUsuario;
import com.alura.forochallengetopico.model.Token;
import com.alura.forochallengetopico.model.Usuario;
import com.alura.forochallengetopico.security.TokenService;
import com.alura.forochallengetopico.service.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {


    private final UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    ResponseEntity<Token> validarToken(@RequestBody AuthUsuario authUsuario) {
        try {
            if (authUsuario.getEmail() == null || authUsuario.getPassword() == null) {
                throw new ErrorException("Email y contraseña son obligatorios");
            }

            Usuario usuario = usuarioRepository.findByEmail(authUsuario.getEmail());
            if (usuario == null) {
                throw new ErrorException("Usuario no encontrado");
            }
            if (!usuario.getPassword().equals(authUsuario.getPassword())) {
                throw new ErrorException("Contraseña incorrecta");
            }
            /*Usuario usuario = new Usuario();
            usuario.setEmail("email");
            usuario.setId(1L);
            usuario.setPassword("password");*/
            Token token = new Token();
            token.setToken(tokenService.generarToken(usuario));
            token.setTipo("Bearer");

            return ResponseEntity.ok(token);
        } catch (ErrorException e) {
            throw new ErrorException(e.getMessage());
        }
    }
}
