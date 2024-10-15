package br.com.spring.conectaAI.controller;

import br.com.spring.conectaAI.domain.institution.InstitutionRequestDTO;
import br.com.spring.conectaAI.service.InstitutionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/institution")
public class InstitutionController {
    @Autowired
    InstitutionService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid InstitutionRequestDTO data){
        service.createInstitution(data);

        return ResponseEntity.ok("Institute Created");
    }
}
