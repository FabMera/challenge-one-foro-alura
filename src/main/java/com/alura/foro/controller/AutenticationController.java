package com.alura.foro.controller;

import com.alura.foro.security.DatosJWT;
import com.alura.foro.security.TokenService;
import com.alura.foro.users.Usuario;
import com.alura.foro.users.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid UsuarioDTO userDTO) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(userDTO.getLogin(), userDTO.getClave());
        var usuarioAutenticated = authenticationManager.authenticate(authToken);
        var JWT = tokenService.generarToken((Usuario) usuarioAutenticated.getPrincipal());
        return ResponseEntity.ok(new DatosJWT(JWT));
    }

}
