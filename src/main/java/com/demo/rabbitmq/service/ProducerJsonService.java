package com.demo.rabbitmq.service;

import com.demo.rabbitmq.model.Eliquidacion;

public interface ProducerJsonService {
    void sendJsonMessage(Eliquidacion eliquidacion);
}
