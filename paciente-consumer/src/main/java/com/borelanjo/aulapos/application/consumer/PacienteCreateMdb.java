package com.borelanjo.aulapos.application.consumer;

import com.borelanjo.aulapos.application.service.PacienteService;
import com.borelanjo.aulapos.domain.model.Paciente;
import com.borelanjo.aulapos.presentation.dto.PacienteTo;
import com.borelanjo.aulapos.presentation.mapper.PacienteMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.borelanjo.aulapos.infrastructure.queue.model.Queue.PACIENTE_CREATION_QUEUE;
import static com.borelanjo.aulapos.presentation.mapper.PacienteMapper.from;

@Service
@Slf4j
@AllArgsConstructor
public class PacienteCreateMdb {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;
    private final UUID codigoUnidade = UUID.randomUUID();
    private final PacienteService pacienteService;

    @JmsListener(destination = PACIENTE_CREATION_QUEUE)
    public void process(byte[] message) {
        try {
            PacienteTo pacienteTo = objectMapper.readValue(message, PacienteTo.class);
            Paciente paciente = pacienteService.update(from(pacienteTo, codigoUnidade));
            log.info("{} recebido pela fila {}", paciente, PACIENTE_CREATION_QUEUE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
