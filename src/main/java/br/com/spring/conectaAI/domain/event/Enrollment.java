//package br.com.spring.conectaAI.domain.event;
//
//import br.com.spring.conectaAI.domain.student.Student;
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//public class Enrollment {
//    @Id
//    Long id;
//
//    @ManyToMany
//    private Student student;
//
//    @ManyToOne
//    @JoinColumn(name = "event_id",nullable = false)
//    private Event event;
//
//    private LocalDateTime enrollment_date;
//}
