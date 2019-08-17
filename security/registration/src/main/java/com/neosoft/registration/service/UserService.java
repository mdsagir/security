package com.neosoft.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.repo.UserRepo;

@Service
public class UserService implements IUserService {

	private UserRepo userRepo;

	@Override
	public boolean checkEmailExist(String email) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Autowired
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
}
