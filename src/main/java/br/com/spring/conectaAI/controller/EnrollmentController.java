package br.com.spring.conectaAI.controller;

import br.com.spring.conectaAI.domain.event.enrollment.EnrollmentResponse;
import br.com.spring.conectaAI.service.EnrollmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EnrollmentController {

    @Autowired
    EnrollmentService service;


    @PostMapping("/{id}/enroll")
    @Transactional
    public ResponseEntity<Void> enroll(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        service.enrollUser(id,userDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/enroll")
    public ResponseEntity<List<EnrollmentResponse>> getEnrollments(@AuthenticationPrincipal UserDetails userDetails){
        var enrollments = service.getAllEnrollmentsByUser(userDetails);
        return ResponseEntity.ok(enrollments);
    }

    @DeleteMapping("/{id}/unroll")
    public ResponseEntity<Void> unroll(@PathVariable Long id,@AuthenticationPrincipal UserDetails userDetails){
        service.unrollUser(id,userDetails);

        return ResponseEntity.noContent().build();
    }
}
