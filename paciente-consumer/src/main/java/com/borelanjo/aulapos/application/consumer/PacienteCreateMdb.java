package com.borelanjo.aulapos.application.consumer;

import com.borelanjo.aulapos.domain.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.borelanjo.aulapos.infrastructure.queue.model.Queue.PACIENTE_CREATION_QUEUE;

@Service
@Slf4j
@AllArgsConstructor
public class PacienteCreateMdb {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = PACIENTE_CREATION_QUEUE)
    public void process(Paciente paciente) {
        try {
            log.info("{} recebido pela fila {}", paciente, PACIENTE_CREATION_QUEUE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
