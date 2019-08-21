package com.neosoft.registration.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.entity.VerificationToken;
import com.neosoft.registration.form.UserForm;
import com.neosoft.registration.repo.UserRepo;
import com.neosoft.registration.repo.VerificationTokenRepo;

@Service
public class UserService implements IUserService {

	private UserRepo userRepo;
	private VerificationTokenRepo tokenRepo;

	@Override
	public boolean checkEmailExist(String email) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public void createVarifacationToken(User user, String token) {
		final VerificationToken verificationToken = new VerificationToken(token, user);
		tokenRepo.save(verificationToken);

	}

	@Override
	public User registerUser(UserForm userForm) {

		User user = new User();

		LocalDateTime date = LocalDateTime.now();

		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setBirthday(date);
		user.setMobile("9052708146");
		user.setGender((byte) 1);
		user.setExpired((byte) 1);
		user.setCredentialExpired((byte) 1);
		user.setEnable((byte) 1);
		user.setCreatedId(1);
		user.setCreatedDate(date);
		user.setUpdatedId(1);
		user.setUpdatedDate(date);

		return userRepo.save(user);
	}

	@Override
	public VerificationToken getVerificationToken(String token) {
		return tokenRepo.findByToken(token);
	}

	@Autowired
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Autowired
	public void setTokenRepo(VerificationTokenRepo tokenRepo) {
		this.tokenRepo = tokenRepo;
	}

	@Override
	public VerificationToken getUser(User user) {
		return tokenRepo.findByUser(user);
	}

}
