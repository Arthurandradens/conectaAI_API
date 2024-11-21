package br.com.spring.conectaAI.domain.teacher;

import br.com.spring.conectaAI.domain.institution.Institution;
import br.com.spring.conectaAI.domain.user.User;
import jakarta.persistence.*;

@Entity(name = "teachers")

public class Teacher {
    @Id
    private long id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "institution_id")
    private Institution institution;
    private String campus;

    public Teacher(User user) {
        this.user = user;
        this.institution = null;
        this.campus = "";
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Institution getInstitution() {
        return institution;
    }

    public String getCampus() {
        return campus;
    }
}
