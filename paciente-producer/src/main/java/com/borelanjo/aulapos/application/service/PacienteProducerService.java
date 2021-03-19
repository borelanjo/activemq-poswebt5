package com.borelanjo.aulapos.application.service;

import com.borelanjo.aulapos.domain.model.Paciente;
import com.borelanjo.aulapos.domain.service.ProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.borelanjo.aulapos.infrastructure.queue.model.Queue.PACIENTE_CREATION_QUEUE;

@Service
@Slf4j
@AllArgsConstructor
public class PacienteProducerService implements ProducerService<Paciente> {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void send(Paciente paciente) {
        try {
            log.info("Enviando {} para o fila : {}", paciente, PACIENTE_CREATION_QUEUE);
            jmsTemplate.convertAndSend(PACIENTE_CREATION_QUEUE, objectMapper.writeValueAsBytes(paciente));
            log.info("Enviado {} enviado para o fila : {}", paciente, PACIENTE_CREATION_QUEUE);
        } catch (Exception e) {
            log.error("Ocorreu um erro durante envio de {}: , {}", paciente, e.getMessage(), e);
        }
    }
}
