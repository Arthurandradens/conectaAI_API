package br.com.spring.conectaAI.domain.institution.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    @Column( name = "postal_code")
    private String postalCode;
    private String number;
    @Column( name = "additional_info")
    private String additionalInfo;
    private String city;
    private String state;


    public Address(AddressRequestDTO address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.postalCode = address.postalCode();
        this.number = address.number();
        this.additionalInfo = address.additionalInfo();
        this.city = address.city();
        this.state = address.state();
    }
}
