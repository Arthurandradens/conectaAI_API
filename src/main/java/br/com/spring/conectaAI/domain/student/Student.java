package br.com.spring.conectaAI.domain.student;

import br.com.spring.conectaAI.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @OneToOne(cascade = CascadeType.ALL)
    public User user;
    public String course;
    public String campus;

    public Student(StudentRequestDTO data, User user) {
        this.user = user;
        this.course = data.course();
        this.campus = data.campus();
    }
}
