package com.borelanjo.aulapos.domain.service;

import javax.jms.Message;

public interface ConsumerService {

    public void process(Message message);
}
