package br.com.spring.conectaAI.controller;

import br.com.spring.conectaAI.domain.event.EventRequestDTO;
import br.com.spring.conectaAI.domain.event.EventResponseDTO;
import br.com.spring.conectaAI.domain.event.EventUpdateRequestDTO;
import br.com.spring.conectaAI.domain.event.enrollment.EnrollmentResponse;
import br.com.spring.conectaAI.service.EventService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    // mudei o nome para service porque na hora de replicar fica mais fácil de adaptar
    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAll() {
        var events = service.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getById(@PathVariable Long id) {
        var event = service.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> create(@RequestBody EventRequestDTO request,@AuthenticationPrincipal UserDetails userDetails) {
        service.createEvent(request,userDetails);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> update(@RequestBody EventUpdateRequestDTO updateRequest,@AuthenticationPrincipal UserDetails userDetails) {
        service.updateEvent(updateRequest, userDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
            service.deleteEvent(id);
            return ResponseEntity.noContent().build();
    }



}
