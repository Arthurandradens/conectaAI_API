package br.com.spring.conectaAI.domain.institution.address;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record AddressRequestDTO(
        @NotBlank
        String street,
        @NotBlank
         String neighborhood,
        @NotBlank
         String postalCode,
        @NotBlank
         String number,
        @Nullable
         String additionalInfo,
        @NotBlank
         String city,
        @NotBlank
         String state
) {
}
