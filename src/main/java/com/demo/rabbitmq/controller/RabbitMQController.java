package com.demo.rabbitmq.controller;

import com.demo.rabbitmq.service.impl.RabbitMQProducerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQProducerServiceImpl.class);

    private RabbitMQProducerServiceImpl rp;

    public RabbitMQController(RabbitMQProducerServiceImpl producer) {
        this.rp = producer;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("msg") String msg) {
        try {
            rp.sendMessage(msg);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("RabbitMQController ERROR: " + e.getMessage());

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
