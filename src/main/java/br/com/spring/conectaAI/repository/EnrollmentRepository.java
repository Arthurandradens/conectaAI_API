package br.com.spring.conectaAI.repository;

import br.com.spring.conectaAI.domain.event.enrollment.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    List<Enrollment> findAllByStudentId(Long id);


    Enrollment findByEventIdAndStudentId(Long eventId,Long studentId);
}
