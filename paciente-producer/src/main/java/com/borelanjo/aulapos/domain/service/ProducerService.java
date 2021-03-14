package com.borelanjo.aulapos.domain.service;

public interface ProducerService<T> {

    public void send(T message);
}
