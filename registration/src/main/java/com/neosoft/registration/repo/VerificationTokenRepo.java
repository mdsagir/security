package com.neosoft.registration.repo;

import org.springframework.data.repository.CrudRepository;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.entity.VerificationToken;

public interface VerificationTokenRepo extends CrudRepository<VerificationToken, Integer> {

	VerificationToken findByToken(String token);

	VerificationToken findByUser(User user);
}
