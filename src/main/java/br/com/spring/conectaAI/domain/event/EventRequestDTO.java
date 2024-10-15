package br.com.spring.conectaAI.domain.event;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
// o DTO vai servir como um modelo que a requisição vai ter que seguir,
// esses vão ser todos os campos que precisão ser enviados na requisição.
// essas anotoções servem para fazer validações simples para que esses campos
// não venham em branco ou nulos
public record EventRequestDTO(
         @NotBlank
         String title,
         @NotBlank
         String description,
         @NotBlank
         String location,
         @NotNull
         @JsonAlias("event_date")
         LocalDateTime eventDate

) {

}
