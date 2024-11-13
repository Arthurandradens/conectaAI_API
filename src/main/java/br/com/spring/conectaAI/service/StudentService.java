package br.com.spring.conectaAI.service;

import br.com.spring.conectaAI.domain.student.Student;
import br.com.spring.conectaAI.domain.student.StudentUpdateDTO;
import br.com.spring.conectaAI.domain.user.User;
import br.com.spring.conectaAI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    public void create(User user){
        var student = new Student(user);
        repository.save(student);
    }

    public void updateStudent(StudentUpdateDTO data, Long id) {
       var student = repository.getReferenceById(id);
       student.updateInfo(data);
       repository.save(student);
    }
}
