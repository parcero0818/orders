package com.melita.orders.respository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.melita.orders.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsernameAndPassword(String username, String password);

}
