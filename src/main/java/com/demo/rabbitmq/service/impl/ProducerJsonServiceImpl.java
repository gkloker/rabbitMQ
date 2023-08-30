package com.demo.rabbitmq.service.impl;

import com.demo.rabbitmq.model.Eliquidacion;
import com.demo.rabbitmq.service.ProducerJsonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public void sendJsonMessage(Eliquidacion eliquidacion) throws Exception {
        LOG.info(String.format("Json mesage sent -> %s", eliquidacion.toString()));

        try {
            rabbitTemplate.convertAndSend(exchange, routingJsonKey, eliquidacion);
        } catch (Exception e) {
            LOG.error("ERROR: " + e.getMessage());
        }
    }
}
