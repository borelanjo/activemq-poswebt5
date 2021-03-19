package com.borelanjo.aulapos.application.service;

import com.borelanjo.aulapos.domain.model.Paciente;
import com.borelanjo.aulapos.infrastructure.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    public Paciente update(Paciente paciente) {
        return nonNull(paciente) ? repository.save(paciente) : null;
    }
}
