package br.com.spring.conectaAI.domain.institution;

import br.com.spring.conectaAI.domain.institution.address.Address;
import br.com.spring.conectaAI.domain.user.User;
import jakarta.persistence.*;

@Entity(name = "institutions")
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

    public Institution(User user) {
        this.user = user;
        this.address = null;
        this.phone = "";
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
