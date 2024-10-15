package br.com.spring.conectaAI.repository;

import br.com.spring.conectaAI.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

