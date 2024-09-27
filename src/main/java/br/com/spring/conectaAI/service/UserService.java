package br.com.spring.conectaAI.service;

import br.com.spring.conectaAI.domain.user.ResgisterDTO;
import br.com.spring.conectaAI.domain.user.User;
import br.com.spring.conectaAI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public UserDetails findByEmail(String email){
        return repository.findByEmail(email);
    }

    public void createUser(ResgisterDTO data) {

        var passwordEncrypted = new BCryptPasswordEncoder().encode(data.password());
        var newUser = new User(data.regNumber(),data.name(),data.email(),passwordEncrypted,data.role());

        repository.save(newUser);

    }
}
