package com.melita.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melita.orders.dto.OrderDto;
import com.melita.orders.dto.Response;
import com.melita.orders.service.OrderService;

@RestController
@RequestMapping("/orders/")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("order")
	public Response<String> login(@RequestBody OrderDto orderDto) {
		return orderService.processOrder(orderDto);
	}

}
