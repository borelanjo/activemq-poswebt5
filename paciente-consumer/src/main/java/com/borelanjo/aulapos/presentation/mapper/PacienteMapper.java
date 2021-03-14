package com.borelanjo.aulapos.presentation.mapper;

import com.borelanjo.aulapos.domain.model.Paciente;
import com.borelanjo.aulapos.presentation.dto.PacienteTo;

import java.util.UUID;

public final class PacienteMapper {

    public static Paciente from(PacienteTo pacienteTo) {
        return Paciente
                .builder()
                .code(pacienteTo.getCode())
                .nome(pacienteTo.getNome())
                .build();
    }

}