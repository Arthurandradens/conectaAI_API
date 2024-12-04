package br.com.spring.conectaAI.repository;

import br.com.spring.conectaAI.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

   Optional<UserDetails> findByEmail(String email);

   Optional<UserDetails> findByRegistrationNumber(String number);

   Optional<User> findUserByEmail(String email);

   Optional<User> findUserByRegistrationNumber(String number);
}
