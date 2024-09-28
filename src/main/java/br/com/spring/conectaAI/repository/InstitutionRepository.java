package br.com.spring.conectaAI.repository;

import br.com.spring.conectaAI.domain.institution.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {
}
