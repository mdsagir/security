package com.neosoft.registration;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.registration.entity.User;
import com.neosoft.registration.repo.UserRepo;
import com.neosoft.registration.util.UserEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	//@Transactional
	public void contextLoads() {
		
		//System.out.println("##########: "+userRepo);
		LocalDateTime  date=LocalDateTime.now();
	
		//Timestamp date=new Timestamp(System.currentTimeMillis());
		
		User user=new User();
		
		user.setFirstName("sagir");
		user.setLastName("ansari");
		user.setEmail("tech.sagir1@gmail.com");
		user.setPassword("passord");
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
		
		userRepo.save(user);
	}

}
