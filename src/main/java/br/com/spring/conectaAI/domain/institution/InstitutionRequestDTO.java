package br.com.spring.conectaAI.domain.institution;

import br.com.spring.conectaAI.domain.institution.address.AddressRequestDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstitutionRequestDTO(
        @NotNull
        @JsonAlias("user_id")
        Long userId,
        @NotNull
        @Valid
        AddressRequestDTO address,
        @NotBlank
        String phone
) {
}
