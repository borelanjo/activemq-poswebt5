package com.borelanjo.aulapos.application.controller;

import com.borelanjo.aulapos.application.service.PacienteProducerService;
import com.borelanjo.aulapos.application.service.ResponseService;
import com.borelanjo.aulapos.domain.model.Paciente;
import com.borelanjo.aulapos.domain.service.ProducerService;
import com.borelanjo.aulapos.presentation.dto.paciente.PacienteRequestTo;
import com.borelanjo.aulapos.presentation.dto.paciente.PacienteResponseTo;
import com.borelanjo.aulapos.presentation.dto.shared.ResponseTo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.borelanjo.aulapos.presentation.mapper.PacienteMapper.from;

@RestController
@RequestMapping("/api/pacientes")
@AllArgsConstructor
public class PacienteController {


    private final ProducerService<Paciente> pacienteService;
    private final ResponseService responseService;

    @PostMapping
    public ResponseEntity<ResponseTo<PacienteResponseTo>> wait(@RequestBody PacienteRequestTo requestTO) {
        Paciente paciente = from(requestTO);

        pacienteService.send(paciente);

        return responseService.accepted(from(paciente));
    }
}
