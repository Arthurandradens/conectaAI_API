package br.com.spring.conectaAI.domain.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentUpdateDTO(

        String course,

        String campus
) {
}
