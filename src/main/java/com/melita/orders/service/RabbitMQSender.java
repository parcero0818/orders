package com.melita.orders.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;

	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;

	public void send(String orderDto) {
		amqpTemplate.convertAndSend(exchange, routingkey, orderDto);
		logger.info("Send msg = " + orderDto);

	}
}
