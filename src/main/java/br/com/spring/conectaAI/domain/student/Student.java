package br.com.spring.conectaAI.domain.student;

import br.com.spring.conectaAI.domain.user.User;
import jakarta.persistence.*;

@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    private String course;
    private String campus;

    public Student(StudentRequestDTO data, User user) {
        this.user = user;
        this.course = data.course();
        this.campus = data.campus();
    }

    public Student() {
    }

    public Student(User user) {
        this.user = user;
        this.course = "";
        this.campus = "";
    }

    public void updateInfo(StudentUpdateDTO data) {
        if (data.course() != null) this.course = data.course();
        if (data.campus() != null) this.campus = data.campus();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getCourse() {
        return course;
    }

    public String getCampus() {
        return campus;
    }
}
