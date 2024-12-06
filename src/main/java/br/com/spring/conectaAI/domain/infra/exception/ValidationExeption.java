package br.com.spring.conectaAI.domain.infra.exception;

public class ValidationExeption extends RuntimeException{
    public ValidationExeption(String message) {
        super(message);
    }
}
