package com.demo.rabbitmq.service;

import com.demo.rabbitmq.model.Eliquidacion;

public interface ConsumerJsonService {
    void consumeJson(Eliquidacion eliq);
}
