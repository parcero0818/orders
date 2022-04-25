package com.melita.orders.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.melita.orders.dto.OrderDto;
import com.melita.orders.dto.Response;
import com.melita.orders.exception.OrderException;
import com.melita.orders.respository.UserRepository;
import com.melita.util.OrderConstants;

@Service
public class OrderService {

	@Autowired
	UserRepository userRepository;

	private Validator validator;
	private RabbitMQSender rabbitSender;

	@Autowired
	public OrderService(RabbitMQSender rabbitSender) {
		this.rabbitSender = rabbitSender;
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	/*
	 * Validate the order information and send message to rabbitmq queue
	 */
	public Response<String> processOrder(OrderDto orderDto) {
		Response<String> response = null;
		try {
			this.verifyObjectData(orderDto);
			this.verifyObjectData(orderDto.getPersonalInformation());
			this.verifyObjectData(orderDto.getProducts());
			String message = new Gson().toJson(orderDto);
			this.rabbitSender.send(message);
			response = new Response<>(HttpStatus.OK.value(), OrderConstants.SUCCESS, null, null);
		} catch (OrderException e) {
			response = new Response<>(e.getStatus(), e.getUserMessage(), e.getMessage(), null);
		} catch (Exception e) {
			response = new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), OrderConstants.ERROR, e.getMessage(),
					null);
		}

		return response;
	}

	public void verifyObjectData(Object objectWithValidations) throws OrderException {
		Set<ConstraintViolation<Object>> invalidData = this.validator.validate(objectWithValidations);
		if (!invalidData.isEmpty()) {
			ConstraintViolation<Object> constraintViolation = invalidData.iterator().next();
			String[] messageCode = constraintViolation.getMessage().split(",");
			throw new OrderException(messageCode[0], messageCode[1], HttpStatus.BAD_REQUEST.value(), messageCode[0]);
		}
	}
}
