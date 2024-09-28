package br.com.spring.conectaAI.domain.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentRequestDTO(
        @NotNull
        Long userId,
        @NotBlank
        String course,
        @NotBlank
        String campus
) {
}
