package br.com.spring.conectaAI.repository;

import br.com.spring.conectaAI.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
