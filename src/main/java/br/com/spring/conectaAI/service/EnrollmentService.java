package br.com.spring.conectaAI.service;

import br.com.spring.conectaAI.domain.event.enrollment.Enrollment;
import br.com.spring.conectaAI.domain.event.enrollment.EnrollmentResponse;
import br.com.spring.conectaAI.repository.EnrollmentRepository;
import br.com.spring.conectaAI.repository.EventRepository;
import br.com.spring.conectaAI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EnrollmentRepository repository;
    @Autowired
    private EventRepository eventRepository;

    public void enrollUser(Long id, UserDetails authUser) {
        var student = studentRepository.findByUserName(authUser.getUsername());
        var event = eventRepository.findById(id);

        if (event.isPresent() && student.isPresent()){
            var enrollment = new Enrollment(event.get(),student.get());
            repository.save(enrollment);
        } else{
            throw new RuntimeException("The event doesn't exist or the user is not valid");
        }
    }

    public List<EnrollmentResponse> getAllEnrollmentsByUser(UserDetails authUser) {
        var student = studentRepository.findByUserName(authUser.getUsername()).orElseThrow(() -> new RuntimeException("User do not exist"));
        var enrollments = repository.findAllByStudentId(student.getId());

        return enrollments.stream().map(EnrollmentResponse::new).toList();


    }

    public void unrollUser(Long id, UserDetails authUser) {
           var student = studentRepository
                                .findByUserName(authUser.getUsername())
                                .orElseThrow(() -> new RuntimeException("The User is not valid"));

    var enrollment = repository.findByEventIdAndStudentId(id,student.getId());

        repository.delete(enrollment);
    }
}
