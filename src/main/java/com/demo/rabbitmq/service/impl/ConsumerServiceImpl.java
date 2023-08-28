package com.demo.rabbitmq.service.impl;

import com.demo.rabbitmq.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String msg) {
        LOG.info(String.format("Msg received: %s", msg));
    }
}
