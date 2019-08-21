package com.neosoft.registration.service;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.entity.VerificationToken;
import com.neosoft.registration.form.UserForm;

public interface IUserService {

	boolean checkEmailExist(String email);

	User registerUser(UserForm userForm);

	void createVarifacationToken(User user, String token);

	VerificationToken getVerificationToken(String token);

	VerificationToken getUser(User user);
}
