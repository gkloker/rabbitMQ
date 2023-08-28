package com.demo.rabbitmq.service;

public interface RabbitMQProducerService {
    void sendMessage(String msg);
}
