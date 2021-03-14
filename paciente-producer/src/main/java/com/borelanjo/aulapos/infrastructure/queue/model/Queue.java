package com.borelanjo.aulapos.infrastructure.queue.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Queue {
    public final static String PACIENTE_CREATION_QUEUE = "PACIENTE-CREATION.QUEUE";
}
