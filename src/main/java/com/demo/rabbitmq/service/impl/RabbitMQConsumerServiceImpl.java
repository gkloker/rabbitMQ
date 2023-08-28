package com.demo.rabbitmq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumerServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQConsumerServiceImpl.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String msg) {
        LOG.info(String.format("Msg received: %s", msg));
    }
}
