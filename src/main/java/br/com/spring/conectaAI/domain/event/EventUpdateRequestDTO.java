package br.com.spring.conectaAI.domain.event;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

// esse DTO se torna necessário pois na hora de editar um evento
// esses campos deixam de ser obrigatórios


public record EventUpdateRequestDTO(
         @NotNull
         // preferi passar o id do evento pelo corpo da requisição
         // para diminuir o numero de parâmetros no controller
         @JsonAlias("event_id")
         Long eventId,
         String title,
         String description,
         String location,
         @JsonAlias("event_date")
         LocalDateTime eventDate

) {

}
