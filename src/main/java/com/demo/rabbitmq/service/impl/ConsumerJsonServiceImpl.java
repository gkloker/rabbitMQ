package com.demo.rabbitmq.service.impl;

import com.demo.rabbitmq.model.Eliquidacion;
import com.demo.rabbitmq.service.ConsumerJsonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerJsonServiceImpl implements ConsumerJsonService {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerJsonServiceImpl.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJson(Eliquidacion eliq) {
        LOG.info(String.format("Received JSON massage: %s", eliq.toString()));
    }
}
