package com.melita.orders.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	/*
	 * method for receiving the information for completing the order
	 */
	@RabbitListener(queues = "order.queue")
	public void receivedMessage(String request) {
		logger.info("Recieved Message From RabbitMQ: {}", request);

	}

}
