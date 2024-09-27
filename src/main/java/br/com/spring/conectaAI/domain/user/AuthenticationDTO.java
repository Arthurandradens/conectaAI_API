package br.com.spring.conectaAI.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AuthenticationDTO(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password) {
}
