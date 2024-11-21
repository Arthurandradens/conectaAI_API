package br.com.spring.conectaAI.service;

import br.com.spring.conectaAI.domain.user.RegisterDTO;
import br.com.spring.conectaAI.domain.user.User;
import br.com.spring.conectaAI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.spring.conectaAI.domain.user.UserRole.*;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    InstitutionService institutionService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    public UserDetails findByEmail(String email){
        return repository.findByEmail(email);
    }

    public void createUser(RegisterDTO data) {

        var passwordEncrypted = new BCryptPasswordEncoder().encode(data.password());
        var newUser = new User(data.regNumber(),data.name(),data.email(),passwordEncrypted,data.role());

        try{
           repository.save(newUser);
            switch (newUser.getRole()){
                case INSTITUTE -> createInstitutionUser(newUser);
                case TEACHER -> createTeacherUser(newUser);
                case STUDENT -> createStudentUser(newUser);
            }

        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    private void createStudentUser(User newUser) {
        studentService.create(newUser);

    }

    private void createTeacherUser(User newUser) {
        teacherService.create(newUser);
    }

    private void createInstitutionUser(User user){
        institutionService.create(user);
    }
}
