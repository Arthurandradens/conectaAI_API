package br.com.spring.conectaAI.repository;

import br.com.spring.conectaAI.domain.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
