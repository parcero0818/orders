package com.melita.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.melita.orders.dto.UserDto;
import com.melita.orders.service.UserService;

@RestController
@RequestMapping("/authentication/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("user")
	public UserDto login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		return userService.getToken(username, pwd);
	}

}
