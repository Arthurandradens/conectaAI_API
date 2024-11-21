//package br.com.spring.conectaAI.domain.infra.seeder;
//
//import br.com.spring.conectaAI.domain.event.Event;
//import br.com.spring.conectaAI.domain.event.EventRequestDTO;
//import br.com.spring.conectaAI.domain.teacher.Teacher;
//import br.com.spring.conectaAI.domain.user.RegisterDTO;
//import br.com.spring.conectaAI.domain.user.User;
//import br.com.spring.conectaAI.repository.EventRepository;
//import br.com.spring.conectaAI.repository.TeacherRepository;
//import br.com.spring.conectaAI.repository.UserRepository;
//import br.com.spring.conectaAI.service.UserService;
//import com.github.javafaker.Faker;
//import jakarta.persistence.EntityManager;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//import static br.com.spring.conectaAI.domain.user.UserRole.TEACHER;
//
//@Component
//public class DatabaseSeeder implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final TeacherRepository teacherRepository;
//    private final EventRepository eventRepository;
//    private final Faker faker = new Faker();
//    private final EntityManager entityManager;
//
//    public DatabaseSeeder(UserRepository userService, TeacherRepository teacherRepository, EventRepository eventRepository, EntityManager entityManager) {
//        this.userRepository = userService;
//        this.teacherRepository = teacherRepository;
//        this.eventRepository = eventRepository;
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public void run(String... args) {
//        var password =  new BCryptPasswordEncoder().encode("12345");
//        User user = new User(null,"Professor","professor@gmail.com",password,TEACHER);
//        userRepository.save(user);
//        var teacher = new Teacher(user);
//        teacherRepository.save(teacher);
//
//        eventRepository.save(new Event(new EventRequestDTO("evento teste","teste","localização",LocalDateTime.now().plusDays(2)), user));
//    }
//}
