package br.com.spring.conectaAI.domain.event;

import br.com.spring.conectaAI.domain.user.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

// Esse é o DTO de resposta, a gente cria ele pois na
// maioria dos casos não vamos enviar todas as informações
// da nossa entidade, então até por uma questão de segurança,
// devemos criar esses records para dar como resposta
@Data
public class EventResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    private UserResponseDTO createdBy;

    public EventResponseDTO(){};

    public EventResponseDTO(Event event) {
       this.id = event.getId();
       this.title = event.getTitle();
       this.description = event.getDescription();
       this.location = event.getLocation();
       this.eventDate = event.getEventDate();
       this.createdBy = new UserResponseDTO(event.getCreatedBy());
    }
}
