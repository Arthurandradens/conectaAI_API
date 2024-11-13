package br.com.spring.conectaAI.service;

import br.com.spring.conectaAI.domain.institution.InstitutionRequestDTO;
import br.com.spring.conectaAI.domain.institution.Institution;
import br.com.spring.conectaAI.domain.user.User;
import br.com.spring.conectaAI.domain.user.UserRole;
import br.com.spring.conectaAI.repository.InstitutionRepository;
import br.com.spring.conectaAI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {
    @Autowired
    InstitutionRepository repository;
    @Autowired
    UserRepository userRepository;
    public void createInstitution(InstitutionRequestDTO data){
        var user = userRepository.findById(data.userId()).orElseThrow(() -> new RuntimeException("User not found"));
        if (user != null && user.getRole() == UserRole.INSTITUTE) {
            var institution = new Institution(data,user);
            repository.save(institution);
        }

    }

    public void create(User user) {
        var institution = new Institution(user);
        repository.save(institution);
    }
}
