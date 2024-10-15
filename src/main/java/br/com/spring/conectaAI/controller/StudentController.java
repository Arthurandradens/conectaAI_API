package br.com.spring.conectaAI.controller;

import br.com.spring.conectaAI.domain.student.Student;
import br.com.spring.conectaAI.domain.student.StudentRequestDTO;
import br.com.spring.conectaAI.repository.StudentRepository;
import br.com.spring.conectaAI.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentRepository repository;
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity getAll(){
       var students = repository.findAll();

       return ResponseEntity.ok(students);
    }
    @PostMapping
    public ResponseEntity create(@RequestBody @Valid StudentRequestDTO data){
        var user = userRepository.findById(data.userId()).orElseThrow(() -> new RuntimeException("User not found"));
        var student = new Student(data,user);
        repository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
