package br.com.spring.conectaAI.domain.user;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String registrationNumber,
        UserRole role
) {
    public UserResponseDTO(User data) {
        this(data.getId(),data.getName(),data.getEmail(),data.getRegistrationNumber(),data.getRole());
    }
}
