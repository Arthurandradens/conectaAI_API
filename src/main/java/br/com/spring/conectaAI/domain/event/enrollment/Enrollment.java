package br.com.spring.conectaAI.domain.event.enrollment;

import br.com.spring.conectaAI.domain.event.Event;
import br.com.spring.conectaAI.domain.student.Student;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Event getEvent() {
        return event;
    }

    public LocalDateTime getEnrollment_date() {
        return enrollment_date;
    }

    @OneToOne
    private Student student;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false)
    private Event event;

    private LocalDateTime enrollment_date;

    public Enrollment(Event event, Student student) {
        this.student = student;
        this.event = event;
        this.enrollment_date = LocalDateTime.now();
    }

    public Enrollment() {
    }
}
