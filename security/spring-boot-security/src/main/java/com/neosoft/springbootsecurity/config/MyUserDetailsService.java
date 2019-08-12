package com.neosoft.springbootsecurity.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private String password = "$2a$10$.u4ynhKpytEE98n6sDKYMOHF6yv9mSkTwPMTsZUY9IdKP8buwR/Ca";

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.equals("sagir")) {

			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));

			return new MyUserDetails(username, password, authorities);
		} else {
			throw new UsernameNotFoundException("UserName not found!");
		}

	}

}
