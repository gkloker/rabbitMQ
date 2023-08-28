package com.demo.rabbitmq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducerServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQProducerServiceImpl.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQProducerServiceImpl(RabbitTemplate rt) {
        this.rabbitTemplate = rt;
    }

    public void sendMessage(String msg) {
        LOG.info(String.format("Msg sent: %s", msg));

        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        } catch (Exception e) {
            LOG.error("RabbitMQProducerServiceImpl ERROR: " + e.getMessage());
        }
    }
}
