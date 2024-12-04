package br.com.spring.conectaAI.service;

import br.com.spring.conectaAI.domain.event.Event;
import br.com.spring.conectaAI.domain.event.EventRequestDTO;
import br.com.spring.conectaAI.domain.event.EventResponseDTO;
import br.com.spring.conectaAI.domain.event.EventUpdateRequestDTO;
import br.com.spring.conectaAI.mapper.GenericMapper;
import br.com.spring.conectaAI.repository.EventRepository;
import br.com.spring.conectaAI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.spring.conectaAI.mapper.GenericMapper.convertObjectToDestiny;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    @Autowired
    // a classe GenericaMapper é uma classe genérica que recebe um
    // um objeto original e um ojeto de destino, nesse classe tem 2
    // métodos de conversões, um de lista e outro simples
    private GenericMapper<Event,EventResponseDTO> mapper;

    @Autowired
    private UserService userService;


    public List<EventResponseDTO> getAllEvents() {
        return repository.findAll().stream().map(EventResponseDTO::new).toList();
    }

    public EventResponseDTO getEventById(Long id) {
        var event = repository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        return convertObjectToDestiny(event,EventResponseDTO.class);
    }

    public void createEvent(EventRequestDTO request, UserDetails authUser) {
        var user = userService.findUserByLogin(authUser.getUsername());
        var event = new Event(request, user);

        repository.save(event);

        convertObjectToDestiny(event, EventResponseDTO.class);
    }

    public void deleteEvent(Long id) {
        var event = repository.findById(id).orElseThrow(() -> new RuntimeException("Event do not exist"));
        repository.delete(event);
    }

    public void updateEvent(EventUpdateRequestDTO updateRequest, UserDetails userDetails) {
       var event = repository.getReferenceById(updateRequest.eventId());
       if (event.getCreatedBy().equals(userDetails) || userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_INSTITUTE"))){
           event.updateInfo(updateRequest);
           repository.save(event);
       } else {
           throw new RuntimeException("Not allowed");
       }
    }

}
