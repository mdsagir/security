package com.neosoft.springbootsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityApplicationTests {

	@Test
	public void contextLoads() {
		
		String encoded = new BCryptPasswordEncoder().encode("password");
		System.out.println(encoded);
	}

}
