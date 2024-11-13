package br.com.spring.conectaAI.domain.teacher;

import br.com.spring.conectaAI.domain.institution.Institution;
import br.com.spring.conectaAI.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "teachers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
}
