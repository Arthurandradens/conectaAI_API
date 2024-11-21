package br.com.spring.conectaAI.domain.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterDTO(
        @NotBlank
        String name,
        @Email
        String email,
        @Nullable
        String regNumber,
        @NotBlank
        @Pattern(regexp = "\\d{6,}",message = "senha precisa ter pelo menos 6 digitos")
        String password,
        @NotNull
        UserRole role
) {
}
