package com.melita.orders.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.melita.orders.dto.UserDto;
import com.melita.orders.model.User;
import com.melita.orders.respository.UserRepository;
import com.melita.util.OrderConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserDto getToken(String username, String password) {
		User user = this.userRepository.findByUsernameAndPassword(username, password).orElse(null);
		if (null != user) {
			String token = getJWTToken(username);
			UserDto userDto = new UserDto();
			userDto.setUser(username);
			userDto.setToken(token);
			return userDto;
		}

		return null;

	}

	private String getJWTToken(String username) {
		String secretKey = OrderConstants.SECRET;
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId(OrderConstants.SOFTTEKJWT).setSubject(username)
				.claim(OrderConstants.AUTHORITIES,
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return OrderConstants.BEARER + token;
	}
}
