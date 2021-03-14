package com.borelanjo.aulapos.presentation.mapper;

import com.borelanjo.aulapos.domain.model.Paciente;
import com.borelanjo.aulapos.presentation.dto.paciente.PacienteRequestTo;
import com.borelanjo.aulapos.presentation.dto.paciente.PacienteResponseTo;

import java.util.UUID;

public final class PacienteMapper {

    public static Paciente from(PacienteRequestTo requestTo) {
        return Paciente
                .builder()
                .code(UUID.randomUUID())
                .nome(requestTo.getNome())
                .build();
    }

    public static PacienteResponseTo from(Paciente paciente) {
        return PacienteResponseTo
                .builder()
                .code(paciente.getCode())
                .nome(paciente.getNome())
                .build();
    }

}