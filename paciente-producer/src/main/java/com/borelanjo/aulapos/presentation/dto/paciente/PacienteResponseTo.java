package com.borelanjo.aulapos.presentation.dto.paciente;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class PacienteResponseTo {
    private UUID code;
    private String nome;
}
