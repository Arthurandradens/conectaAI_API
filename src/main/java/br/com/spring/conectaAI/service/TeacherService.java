package br.com.spring.conectaAI.service;

import br.com.spring.conectaAI.domain.student.Student;
import br.com.spring.conectaAI.domain.teacher.Teacher;
import br.com.spring.conectaAI.domain.user.User;
import br.com.spring.conectaAI.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;
    public void create(User user){
        var teacher = new Teacher(user);
        repository.save(teacher);
    }

}
