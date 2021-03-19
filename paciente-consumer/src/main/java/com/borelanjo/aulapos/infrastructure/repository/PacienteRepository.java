package com.borelanjo.aulapos.infrastructure.repository;

import com.borelanjo.aulapos.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    public Optional<Paciente> findByCode(UUID code);
}
