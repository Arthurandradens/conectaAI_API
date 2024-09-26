package br.com.spring.conectaAI.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {
    INSTITUTE("institute"),
    TEACHER("teacher"),
    STUDENT("student");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

}
