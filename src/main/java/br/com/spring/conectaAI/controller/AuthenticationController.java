package br.com.spring.conectaAI.controller;

import br.com.spring.conectaAI.domain.infra.security.TokenService;
import br.com.spring.conectaAI.domain.user.AuthenticationDTO;
import br.com.spring.conectaAI.domain.user.LoginResponseDTO;
import br.com.spring.conectaAI.domain.user.RegisterDTO;
import br.com.spring.conectaAI.domain.user.User;
import br.com.spring.conectaAI.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService service;
    @Autowired
    TokenService tokenService;
    @PostMapping("/login")
    @Transactional
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(),data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if (service.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
        service.createUser(data);
        return ResponseEntity.ok().build();
    }


}
