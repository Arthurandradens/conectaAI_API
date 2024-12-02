package br.com.spring.conectaAI.service;

import br.com.spring.conectaAI.domain.event.*;
import br.com.spring.conectaAI.domain.event.enrollment.Enrollment;
import br.com.spring.conectaAI.domain.event.enrollment.EnrollmentResponse;
import br.com.spring.conectaAI.mapper.GenericMapper;
import br.com.spring.conectaAI.repository.EnrollmentRepository;
import br.com.spring.conectaAI.repository.EventRepository;
import br.com.spring.conectaAI.repository.StudentRepository;
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
    private UserRepository userRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<EventResponseDTO> getAllEvents() {
        return repository.findAll().stream().map(EventResponseDTO::new).toList();
    }

    public EventResponseDTO getEventById(Long id) {
        var event = repository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        return convertObjectToDestiny(event,EventResponseDTO.class);
    }

    public void createEvent(EventRequestDTO request, UserDetails authUser) {
        var user = userRepository.findUserByEmail(authUser.getUsername());
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

    public void enrollUser(Long id, UserDetails authUser) {
        var student = studentRepository.findByUserName(authUser.getUsername());
        var event = repository.findById(id);

        if (event.isPresent() && authUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STUDENT"))){
            var enrollment = new Enrollment(event.get(),student);
            enrollmentRepository.save(enrollment);
        } else{
            throw new RuntimeException("The event doesn't exist or the user id not valid");
        }
    }

    public List<EnrollmentResponse> getAllEnrollmentsByUser(UserDetails authUser) {
        var student = studentRepository.findByUserName(authUser.getUsername());
        var enrollments = enrollmentRepository.findAllByStudentId(student.getId());
        if (!enrollments.isEmpty()){
            return enrollments.stream().map(EnrollmentResponse::new).toList();
        }
       throw new RuntimeException("this user doesn't have any enrollment");
    }
}
