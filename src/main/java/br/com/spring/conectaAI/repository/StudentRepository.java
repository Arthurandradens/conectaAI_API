package br.com.spring.conectaAI.repository;

import br.com.spring.conectaAI.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("""
            select s
            from students s\s
            inner join users u on (u.email = :username)
            where s.user.id = u.id\s
           \s""")
    Optional<Student> findByUserName(String username);
}
