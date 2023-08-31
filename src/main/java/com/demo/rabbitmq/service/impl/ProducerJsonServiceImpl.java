package com.demo.rabbitmq.service.impl;

import com.demo.rabbitmq.model.Eliquidacion;
import com.demo.rabbitmq.service.ProducerJsonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerJsonServiceImpl implements ProducerJsonService {
    private static final Logger LOG = LoggerFactory.getLogger(ProducerJsonServiceImpl.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    RabbitTemplate rabbitTemplate;

    public ProducerJsonServiceImpl(RabbitTemplate rt) {
        this.rabbitTemplate = rt;
    }

    public void sendJsonMessage(Eliquidacion eliquidacion) {
        LOG.info(String.format("Json mesage sent -> %s", eliquidacion.toString()));

        try {
            rabbitTemplate.convertAndSend(exchange, routingJsonKey, eliquidacion);
        } catch (Exception e) {
            LOG.error("ERROR: " + e.getMessage());
        }
    }
}
