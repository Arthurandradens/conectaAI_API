package br.com.spring.conectaAI.domain.event;

import br.com.spring.conectaAI.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

// com o lombok a gente não precisa criar os getters e nem os construtores
// a gente não vai usar nenhum setter justamente pq a incercão dos dados vai
// ser via construtor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Event(EventRequestDTO request, User user) {
        this.title = request.title();
        this.description = request.description();
        this.location = request.location();
        this.eventDate = request.eventDate();
        this.createdBy = user;
    }

    public void updateInfo(EventUpdateRequestDTO data) {
        if (data.title() != null) this.title = data.title();

        if (data.description() != null) this.description = data.description();

        if (data.location() != null) this.location = data.location();

        if (data.eventDate() != null) this.eventDate = data.eventDate();

    }
}
