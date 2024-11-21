package br.com.spring.conectaAI.domain.user;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String registrationNumber;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(String registrationNumber,String name,String email, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationNumber = registrationNumber;
        this.role = role;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADM){
            return List.of(new SimpleGrantedAuthority("ROLE_INSTITUTE"),
                    new SimpleGrantedAuthority("ROLE_TEACHER"),
                    new SimpleGrantedAuthority("ROLE_ADM"),
                    new SimpleGrantedAuthority("ROLE_STUDENT"));
        }
        else if (this.role == UserRole.INSTITUTE){
            return List.of(new SimpleGrantedAuthority("ROLE_INSTITUTE"),
                    new SimpleGrantedAuthority("ROLE_TEACHER"),
                    new SimpleGrantedAuthority("ROLE_STUDENT"));
        } else if (this.role == UserRole.TEACHER) {
           return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"), new SimpleGrantedAuthority("ROLE_STUDENT"));
        } else{
            return List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));
        }
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
