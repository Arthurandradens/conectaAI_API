package br.com.spring.conectaAI.domain.institution;

import br.com.spring.conectaAI.domain.institution.address.Address;
import br.com.spring.conectaAI.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "institutions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @OneToOne(cascade = CascadeType.ALL)
    public User user;
    @Embedded
    public Address address;
    public String phone;

    public Institution(InstitutionRequestDTO data, User user) {
        this.user = user;
        this.address = new Address(data.address());
        this.phone = data.phone();
    }
}
