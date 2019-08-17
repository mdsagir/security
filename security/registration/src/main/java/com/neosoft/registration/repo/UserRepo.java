package com.neosoft.registration.repo;

import org.springframework.data.repository.CrudRepository;

import com.neosoft.registration.entity.User;

public interface UserRepo  extends CrudRepository<User, Integer>{

	User findByEmail(String email);
}
