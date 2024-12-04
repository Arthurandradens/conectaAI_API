package br.com.spring.conectaAI.domain.user;

public record LoginResponseDTO(
        UserResponseDTO user,
        String token
) {
    public LoginResponseDTO(User user, String token) {
        this(new UserResponseDTO(user),token);
    }
}
