package br.com.spring.conectaAI.domain.event.enrollment;

import br.com.spring.conectaAI.domain.event.Event;
import br.com.spring.conectaAI.domain.event.EventResponseDTO;

import java.time.LocalDateTime;

public class EnrollmentResponse {
    private Long id;
    private EventResponseDTO event;
    private LocalDateTime enrollment_date;

    public EnrollmentResponse(Enrollment enrollment) {
        this.id = enrollment.getId();
        this.event = new EventResponseDTO(enrollment.getEvent());
        this.enrollment_date = enrollment.getEnrollment_date();
    }

    public Long getId() {
        return id;
    }

    public EventResponseDTO getEvent() {
        return event;
    }

    public LocalDateTime getEnrollment_date() {
        return enrollment_date;
    }
}
