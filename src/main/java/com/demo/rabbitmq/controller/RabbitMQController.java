package com.demo.rabbitmq.controller;

import com.demo.rabbitmq.model.Eliquidacion;
import com.demo.rabbitmq.service.impl.ProducerJsonServiceImpl;
import com.demo.rabbitmq.service.impl.ProducerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {
    private static final Logger LOG = LoggerFactory.getLogger(ProducerServiceImpl.class);

    private ProducerServiceImpl producerService;
    private ProducerJsonServiceImpl producerJsonService;

    public RabbitMQController(ProducerServiceImpl producer, ProducerJsonServiceImpl producerJson) {
        this.producerService = producer;
        this.producerJsonService = producerJson;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("msg") String msg) {
        try {
            producerService.sendMessage(msg);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("ERROR: " + e.getMessage());

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/sendjson")
    public ResponseEntity<Eliquidacion> sendJsonMessage(@RequestBody Eliquidacion eliq) {
        try {
            producerJsonService.sendJsonMessage(eliq);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("ERROR: " + e.getMessage());

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
